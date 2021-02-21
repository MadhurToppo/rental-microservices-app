package com.madhurtoppo.rentalapp.rentalui.controller;

import com.madhurtoppo.rentalapp.rentalui.config.AccessToken;
import com.madhurtoppo.rentalcommons.model.customer.Customer;
import com.madhurtoppo.rentalcommons.model.product.Product;
import com.madhurtoppo.rentalcommons.model.rent.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * @author Madhur Toppo
 * @since 15 March 2020
 */
@Controller
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RentController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/rents")
    public String loadEverything(Model model) {
        HttpEntity<Rent> rentHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
        HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
        HttpEntity<Product> productHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
        try {
            ResponseEntity<Rent[]> rentResponseEntity = restTemplate.exchange("http://rent-service/services/rents", HttpMethod.GET, rentHttpEntity, Rent[].class);
            model.addAttribute("rents", rentResponseEntity.getBody());
            ResponseEntity<Customer[]> customerResponseEntity = restTemplate.exchange("http://customer-service/services/customers", HttpMethod.GET, customerHttpEntity, Customer[].class);
            model.addAttribute("customers", customerResponseEntity.getBody());
            ResponseEntity<Product[]> productResponseEntity = restTemplate.exchange("http://product-service/services/products", HttpMethod.GET, productHttpEntity, Product[].class);
            model.addAttribute("products", productResponseEntity.getBody());
        } catch (HttpStatusCodeException e) {
            ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error", responseEntity);
        }
        return "rents";
    }

    @GetMapping(value = "/rental")
    @ResponseBody
    public ResponseEntity<Rent[]> loadAllRents() {
        HttpEntity<Rent> rentHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
        ResponseEntity<Rent[]> rentResponseEntity = restTemplate.exchange("http://rent-service/services/rents", HttpMethod.GET, rentHttpEntity, Rent[].class);
        return rentResponseEntity;
    }

    @GetMapping(value = "/monthData")
    @ResponseBody
    public ResponseEntity<Object> loadMonthData() {
        HttpEntity<Object> monthHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
        ResponseEntity<Object> rentResponseEntity = restTemplate.exchange("http://rent-service/services/rents/monthData", HttpMethod.GET, monthHttpEntity, Object.class);
//    ResponseEntity<Object> rentResponseEntity = restTemplate.exchange("http://192.168.99.101:7575/services/rents/monthData", HttpMethod.GET, monthHttpEntity, Object.class);
        return rentResponseEntity;
    }

    @GetMapping(value = "/productData")
    @ResponseBody
    public ResponseEntity<Object> loadProductData() {
        HttpEntity<Object> productDataHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
        ResponseEntity<Object> productDataResponseEntity = restTemplate.exchange("http://rent-service/services/rents/productData", HttpMethod.GET, productDataHttpEntity, Object.class);
//    ResponseEntity<Object> productDataResponseEntity = restTemplate.exchange("http://192.168.99.101:7575/services/rents/productData", HttpMethod.GET, productDataHttpEntity, Object.class);
        return productDataResponseEntity;
    }

    @GetMapping(value = "/cityData")
    @ResponseBody
    public ResponseEntity<Object> loadCityData() {
        HttpEntity<Object> cityDataHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
        ResponseEntity<Object> cityDataResponseEntity = restTemplate.exchange("http://rent-service/services/rents/cityData", HttpMethod.GET, cityDataHttpEntity, Object.class);
//    ResponseEntity<Object> cityDataResponseEntity = restTemplate.exchange("http://192.168.99.101:7575/services/rents/cityData", HttpMethod.GET, cityDataHttpEntity, Object.class);
        return cityDataResponseEntity;
    }

    @GetMapping(value = "/lensData")
    @ResponseBody
    public Map<String, Integer> getLensData() {
        HttpEntity<Product> productHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
        HttpEntity<Rent> rentHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
        ResponseEntity<Rent[]> rentResponseEntity = restTemplate.exchange("http://rent-service/services/rents", HttpMethod.GET, rentHttpEntity, Rent[].class);

        List<Rent> rentList = Arrays.asList(rentResponseEntity.getBody());
        HashMap<String, Integer> map = new HashMap<>();

        for (Rent rent : rentList) {
            ResponseEntity<Product> productResponseEntity = restTemplate.exchange("http://product-service/services/product/" + rent.getProductId(), HttpMethod.GET, productHttpEntity, Product.class);
            Product product = productResponseEntity.getBody();
            String model = product.getModel();
            Integer value = (!map.containsKey(model)) ? 0 : map.get(model) + 1;
            map.put(model, value);
        }
        return map;
    }

    @PostMapping(value = "/rents/addNew")
    public String addNew(Rent rent) {
        HttpEntity<Rent> rentHttpEntity = new HttpEntity<>(rent, AccessToken.getHttpHeaders());
        try {
            ResponseEntity<Rent> responseEntity = restTemplate.exchange("http://rent-service/services/rents", HttpMethod.POST, rentHttpEntity, Rent.class);
        } catch (HttpStatusCodeException e) {
            ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            System.out.println("From error: " + responseEntity);
        }
        return "redirect:/rents";
    }

    @GetMapping("/rent/{id}")
    @ResponseBody
    public ResponseEntity<Rent> findById(@PathVariable int id) {
        HttpEntity<Rent> rentHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
        ResponseEntity<Rent> responseEntity = restTemplate.exchange("http://rent-service/services/rents/" + id, HttpMethod.GET, rentHttpEntity, Rent.class);
        return responseEntity;
    }

    @RequestMapping(value = "/rents/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Rent rent) {
        HttpEntity<Rent> rentHttpEntity = new HttpEntity<>(rent, AccessToken.getHttpHeaders());
        try {
            ResponseEntity<Rent> responseEntity = restTemplate.exchange("http://rent-service/services/rents", HttpMethod.POST, rentHttpEntity, Rent.class);
        } catch (HttpStatusCodeException e) {
            ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
        }
        return "redirect:/rents";
    }

    @RequestMapping(value = "/rents/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable int id) {
        HttpEntity<Rent> rentHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
        ResponseEntity<Rent> responseEntity = restTemplate.exchange("http://rent-service/services/rents/delete/" + id, HttpMethod.DELETE, rentHttpEntity, Rent.class);
        return "redirect:/rents";
    }

}
