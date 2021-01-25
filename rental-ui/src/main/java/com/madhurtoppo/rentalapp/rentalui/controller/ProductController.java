package com.madhurtoppo.rentalapp.rentalui.controller;

import com.madhurtoppo.rentalapp.rentalui.config.AccessToken;
import com.madhurtoppo.rentalcommons.model.product.Product;
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

/***
 * @author Madhur Toppo
 * @since 15 March 2020
 */
@Controller
public class ProductController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/products")
    public String loadProducts(Model model) {
        HttpEntity<Product> productHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
        try {
            ResponseEntity<Product[]> responseEntity = restTemplate.exchange("http://product-service/services/products", HttpMethod.GET, productHttpEntity, Product[].class);
            model.addAttribute("products", responseEntity.getBody());
        } catch (HttpStatusCodeException e) {
            ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error", responseEntity);
        }
        return "products";
    }

    @PostMapping(value = "/products/addNew")
    public String addNew(Product product) {
        HttpEntity<Product> productHttpEntity = new HttpEntity<>(product, AccessToken.getHttpHeaders());
        try {
            ResponseEntity<Product> responseEntity = restTemplate.exchange("http://product-service/services/product", HttpMethod.POST, productHttpEntity, Product.class);
        } catch (HttpStatusCodeException e) {
            ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
        }
        return "redirect:/products";
    }

    @GetMapping("/product/{id}")
    @ResponseBody
    public ResponseEntity<Product> findById(@PathVariable int id) {
        HttpEntity<Product> productHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
        ResponseEntity<Product> responseEntity = restTemplate.exchange("http://product-service/services/product/" + id, HttpMethod.GET, productHttpEntity, Product.class);
        return responseEntity;
    }

    @RequestMapping(value = "/products/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Product product) {
        HttpEntity<Product> productHttpEntity = new HttpEntity<>(product, AccessToken.getHttpHeaders());
        try {
            ResponseEntity<Product> responseEntity = restTemplate.exchange("http://product-service/services/product", HttpMethod.POST, productHttpEntity, Product.class);
        } catch (HttpStatusCodeException e) {
            ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
        }
        return "redirect:/products";
    }

    @RequestMapping(value = "/product/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
//  @ResponseBody
    public String delete(@PathVariable int id) {
        HttpEntity<Product> productHttpEntity = new HttpEntity<>(AccessToken.getHttpHeaders());
        ResponseEntity<Product> responseEntity = restTemplate.exchange("http://product-service/services/product/delete/" + id, HttpMethod.DELETE, productHttpEntity, Product.class);
        return "redirect:/products";
    }

}
