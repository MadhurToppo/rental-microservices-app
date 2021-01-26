package com.madhurtoppo.rentalapp.rentservice.repository;

import com.madhurtoppo.rentalapp.rentservice.model.RentedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/***
 * @author Madhur Toppo
 * @since 15 March 2020
 */
public interface RentedProductRepository extends JpaRepository<RentedProduct, Integer> {

    @Query("SELECT NEW map(model as model, category as category, COUNT(DISTINCT id) as count) FROM RentedProduct group by model, category")
    List<Map<String, Object>> findProductData();

}
