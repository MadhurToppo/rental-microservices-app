package com.madhurtoppo.rentalapp.rentalui.controller;

import com.madhurtoppo.rentalapp.rentalui.config.AccessToken;
import com.madhurtoppo.rentalapp.rentalui.config.IPAddress;
import com.madhurtoppo.rentalcommons.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Controller
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

  @Autowired
  RestTemplate restTemplate;

  /**
   * Method to get Http header with Authorization Access Token
   *
   * @return
   */
  public HttpHeaders loadHttpHeaders() {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Authorization", AccessToken.getAccessToken());
    return httpHeaders;
  }

  /**
   * Method to display the list of Customers
   *
   * @param model
   * @return customers list page
   */
  @GetMapping(value = "/customers")
  public String loadCustomers(Model model) {
    HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
    try {
//      IPAddress.getIPAddress();
      ResponseEntity<Customer[]> responseEntity = restTemplate.exchange("http://customer-service/services/customers", HttpMethod.GET, customerHttpEntity, Customer[].class);
//      ResponseEntity<Customer[]> responseEntity = restTemplate.exchange("http://customer/services/customers", HttpMethod.GET, customerHttpEntity, Customer[].class);
      //      ResponseEntity<Customer[]> responseEntity = restTemplate.exchange("http://192.168.99.101:7272/services/customers", HttpMethod.GET, customerHttpEntity, Customer[].class);
//      ResponseEntity<Customer[]> responseEntity = restTemplate.exchange("http://172.17.0.8:7272/services/customers", HttpMethod.GET, customerHttpEntity, Customer[].class);
      model.addAttribute("customers", responseEntity.getBody());
    } catch (HttpStatusCodeException e) {
      ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
      model.addAttribute("error", responseEntity);
    }
    return "customers";
  }

  /**
   * Method to add a new Customer
   *
   * @param customer
   * @return to customers page after adding new customer
   */
  @PostMapping(value = "/customers/addNew")
  public String addNew(Customer customer) {
    HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(customer, AccessToken.getHttpHeaders());
    try {
      ResponseEntity<Customer> responseEntity = restTemplate.exchange("http://customer-service/services/customer", HttpMethod.POST, customerHttpEntity, Customer.class);
    } catch (HttpStatusCodeException e) {
      ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
    }
    return "redirect:/customers";
  }

  /**
   * Method to get the Customer object in Json format by the Customer Id
   *
   * @param id
   * @return Customer Object
   */
  @GetMapping("/customer/{id}")
  @ResponseBody
  public ResponseEntity<Customer> findById(@PathVariable int id) {
    HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
    return restTemplate.exchange("http://customer-service/services/customer/" + id, HttpMethod.GET, customerHttpEntity, Customer.class);
  }

  /**
   * Method to update the Customer details
   *
   * @param customer
   * @return to customers page after update
   */
  @RequestMapping(value = "/customers/update", method = {RequestMethod.PUT, RequestMethod.GET})
  public String update(Customer customer) {
    HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(customer, AccessToken.getHttpHeaders());
    try {
      ResponseEntity<Customer> responseEntity = restTemplate.exchange("http://customer-service/services/customer", HttpMethod.POST, customerHttpEntity, Customer.class);
    } catch (HttpStatusCodeException e) {
      ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
    }
    return "redirect:/customers";
  }

  /**
   * Method to delete the Customer
   *
   * @param id
   * @return to the Customer page after deletion
   */
  @RequestMapping(value = "/customer/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
  public String delete(@PathVariable int id) {
    HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
    ResponseEntity<Customer> responseEntity = restTemplate.exchange("http://customer-service/services/customer/delete/" + id, HttpMethod.DELETE, customerHttpEntity, Customer.class);
    return "redirect:/customers";
  }

}
