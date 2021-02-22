package com.madhurtoppo.rentalapp.productservice.repository;

import com.madhurtoppo.rentalcommons.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * @author Madhur Toppo
 * @since 15 March 2020
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
