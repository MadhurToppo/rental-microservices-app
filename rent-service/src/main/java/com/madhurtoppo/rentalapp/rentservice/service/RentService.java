package com.madhurtoppo.rentalapp.rentservice.service;

import com.madhurtoppo.rentalapp.rentservice.model.DetailResponse;
import com.madhurtoppo.rentalapp.rentservice.model.RentedProduct;
import com.madhurtoppo.rentalcommons.model.rent.Rent;

import java.util.List;
import java.util.Map;

/***
 * @author Madhur Toppo
 * @since 28 March 2020
 */
public interface RentService {
    Rent save(Rent rent);

    Rent findById(int id);

    List<Rent> findAll();

    DetailResponse findDetailResponse(int id);

    List<DetailResponse> getAllDetailResponses();

    void delete(int id);

    Map<String, Integer> getMonthlyData();

    RentedProduct saveProduct(RentedProduct rentedProduct);

    List<Map<String, Object>> getProductData();

    List<Map<String, Object>> getCityData();

}


