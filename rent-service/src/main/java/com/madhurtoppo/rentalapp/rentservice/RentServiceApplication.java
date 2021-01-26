package com.madhurtoppo.rentalapp.rentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/***
 * Rent service for customer to product rental information
 * @author Madhur Toppo
 * @version 1.0
 * @since 15 March 2020
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.madhurtoppo.rentalcommons.model.rent", "com.madhurtoppo.rentalapp.rentservice.model"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableDiscoveryClient
public class RentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentServiceApplication.class, args);
    }

}
