package com.madhurtoppo.rentalapp.productservice.controller;

import com.madhurtoppo.rentalapp.productservice.service.ProductService;
import com.madhurtoppo.rentalcommons.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * @author Madhur Toppo
 */
@RestController
@RequestMapping(value = "/services")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public Product fetch(@PathVariable int productId) {
        return productService.fetchById(productId);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<Product> fetch() {
        return productService.fetchAllProducts();
    }

    @RequestMapping(value = "/product/delete/{productId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ROLE_admin')")
    public void delete(@PathVariable int productId) {
        productService.delete(productId);
    }

}
