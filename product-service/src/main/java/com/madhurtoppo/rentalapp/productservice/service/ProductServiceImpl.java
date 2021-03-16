package com.madhurtoppo.rentalapp.productservice.service;

import com.madhurtoppo.rentalapp.productservice.repository.ProductRepository;
import com.madhurtoppo.rentalcommons.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/***
 * @author Madhur Toppo
 * @since 15th March 2020
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product fetchById(int productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.orElse(null);
    }

    @Override
    public List<Product> fetchAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void delete(int productId) {
        productRepository.deleteById(productId);
    }

}
