package com.madhurtoppo.rentalapp.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/***
 * Product service for camera models and accessories
 * @author Madhur Toppo
 * @version 1.0
 * @since 15 March 2020
 */
@SpringBootApplication
@EntityScan(basePackages = "com.madhurtoppo.rentalcommons.model.product")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableDiscoveryClient
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
