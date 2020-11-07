package com.madhurtoppo.rentalapp.productservice.repository;

import com.madhurtoppo.rentalcommons.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * @author Madhur Toppo
 * @version 1.0
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
