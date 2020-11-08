package com.madhurtoppo.rentalapp.rentservice.repository;

import com.madhurtoppo.rentalcommons.model.rent.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/***
 * @author Madhur Toppo
 * @version 1.0
 */
public interface RentRepository extends JpaRepository<Rent, Integer> {
    Integer countByProductId(Integer productId);

    @Query("SELECT \n" +
            " rentLocation as location,\n" +
            "\tCount(CASE MONTH(rentFrom ) WHEN 1 THEN 1 END) AS Jan,\n" +
            "\tCount(CASE MONTH(rentFrom) WHEN 2 THEN 1 END) AS Feb,\n" +
            "\tCount(CASE MONTH(rentFrom) WHEN 3 THEN 1 END) AS Mar,\n" +
            "\tCount(CASE MONTH(rentFrom) WHEN 4 THEN 1 END) AS Apr,\n" +
            "\tCount(CASE MONTH(rentFrom) WHEN 5 THEN 1 END) AS May,\n" +
            "\tCount(CASE MONTH(rentFrom) WHEN 6 THEN 1 END) AS Jun,\n" +
            "\tCount(CASE MONTH(rentFrom) WHEN 7 THEN 1 END) AS Jul,\n" +
            "\tCount(CASE MONTH(rentFrom) WHEN 8 THEN 1 END) AS Aug,\n" +
            "\tCount(CASE MONTH(rentFrom) WHEN 9 THEN 1 END) AS Sep,\n" +
            "\tCount(CASE MONTH(rentFrom) WHEN 10 THEN 1 END) AS Oct,\n" +
            "\tCount(CASE MONTH(rentFrom) WHEN 11 THEN 1 END) AS Nov,\n" +
            "\tCount(CASE MONTH(rentFrom) WHEN 12 THEN 1 END) AS Dec\n" +
            "FROM Rent WHERE YEAR(rentFrom) = '2019'\n" +
            "GROUP BY YEAR(rentFrom), rentLocation, YEAR(rentFrom)")
    List<Map<String, Object>> fetchCityData();

}
