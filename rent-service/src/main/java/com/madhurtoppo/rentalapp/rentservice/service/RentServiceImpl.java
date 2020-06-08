package com.madhurtoppo.rentalapp.rentservice.service;

import com.madhurtoppo.rentalapp.rentservice.config.AccessToken;
import com.madhurtoppo.rentalapp.rentservice.model.DetailResponse;
import com.madhurtoppo.rentalapp.rentservice.model.RentedProduct;
import com.madhurtoppo.rentalapp.rentservice.repository.RentRepository;
import com.madhurtoppo.rentalapp.rentservice.repository.RentedProductRepository;
import com.madhurtoppo.rentalcommons.model.customer.Customer;
import com.madhurtoppo.rentalcommons.model.product.Product;
import com.madhurtoppo.rentalcommons.model.rent.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Month;
import java.util.*;

@Service
public class RentServiceImpl implements RentService {

  @Autowired
  RentRepository rentRepository;

  @Autowired
  RentedProductRepository rentedProductRepository;

//  @Bean
//  RestTemplate getRestTemplate(RestTemplateBuilder builder) {
//    return builder.build();
//  }

  @Autowired
  RestTemplate restTemplate;

  @Override
  public Map<String, Integer> getMonthlyData() {
    HashMap<String, Integer> map = new HashMap<>();
    List<Rent> rentList = rentRepository.findAll();

    for (Rent rent : rentList) {
      String month = rent.getRentFrom().getMonth().toString();
      Integer value = (!map.containsKey(month)) ? 0 : map.get(month) + 1;
      map.put(month, value);
    }
    return map;
  }

  @Override
  public Rent save(Rent rent) {
//  Rent rental = rentRepository.save(rent);

    /**
     * 1. Get ProductId Id from Rent object {Done}
     * 2. Get Product object from productId (Rest Call) {Done}
     * 3. Construct Rented Product object from Product data (save into Database) {Done}
     * 4. Call saveProduct() method using the RentedProduct object {Done}
     */
//    Integer productId = rental.getProductId();
    Integer productId = rent.getProductId();

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Authorization", AccessToken.getAccessToken());
    HttpEntity<Product> productHttpEntity = new HttpEntity<>(httpHeaders);
    ResponseEntity<Product> productResponseEntity = restTemplate.exchange("http://product-service/services/product/" + productId, HttpMethod.GET, productHttpEntity, Product.class);
    Product product = productResponseEntity.getBody();
//    System.out.println("The Rented product is: " + product);

    RentedProduct rentedProduct = new RentedProduct();

//    Refactor code to use constructor to create rentedProduct object
    rentedProduct.setId(rent.getRentId());
    rentedProduct.setProductId(product.getId());
    rentedProduct.setMake(product.getMake());
    rentedProduct.setModel(product.getModel());
    rentedProduct.setType(product.getType());
    rentedProduct.setCategory(product.getCategory());
    rentedProduct.setYear(product.getYear());

    saveProduct(rentedProduct);
//  rentedProductRepository.save(rentedProduct);
//  Integer count = rentRepository.countByProductId(38);
//  System.out.println("The count is: " + count);
    return rentRepository.save(rent);
  }

  @Override
  public Rent findById(int id) {
    Optional<Rent> rent = rentRepository.findById(id);
    if (rent.isPresent())
      return rent.get();
    else
      return new Rent();
  }

  @Override
  public List<Map<String, Object>> getProductData() {
    /**
     * 1. Write a custom query to get count of individual models (in DB)
     * 2. Create method in JPA Repository to get the items
     */
    List<Map<String, Object>> productCountMap = rentedProductRepository.findProductData();
//    System.out.println("The product data is: " + productCountMap);
    return productCountMap;
  }

  @Override
  public List<Map<String, Object>> getCityData() {
    List<Map<String,Object>> cityCountMap = rentRepository.fetchCityData();
    return cityCountMap;
  }

  @Override
  public List<Rent> findAll() {
    return rentRepository.findAll();
  }

  @Override
  public DetailResponse findDetailResponse(int id) {
    Rent rent = findById(id);
    Customer customer = getCustomer(rent.getCustomerId());
    Product product = getProduct(rent.getProductId());
    return new DetailResponse(rent, customer, product);
  }

  @Override
  public List<DetailResponse> getAllDetailResponses() {
    List<Rent> rentList = findAll();
    List<DetailResponse> detailResponseList = new ArrayList<>();
    for (Rent rent : rentList) {
      detailResponseList.add(findDetailResponse(rentList.indexOf(rent)));
    }
//    System.out.println("Detailed rent list is: " + detailResponseList);
    return detailResponseList;
  }

  @Override
  public RentedProduct saveProduct(RentedProduct rentedProduct) {
    return rentedProductRepository.save(rentedProduct);
  }

  @Override
  public void delete(int id) {
    rentRepository.deleteById(id);
  }

  private Customer getCustomer(int customerId) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Authorization", AccessToken.getAccessToken());
    HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(httpHeaders);
    Customer customer = restTemplate.getForObject("http://localhost:7272/services/customers/" + customerId, Customer.class, customerHttpEntity);
    return customer;
  }

  private Product getProduct(int productId) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Authorization", AccessToken.getAccessToken());
    HttpEntity<Product> productHttpEntity = new HttpEntity<>(httpHeaders);
    Product product = restTemplate.getForObject("http://localhost:7373/services/product/" + productId, Product.class, productHttpEntity);
    return product;
  }

}