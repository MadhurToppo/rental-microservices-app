package com.madhurtoppo.rentalapp.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/***
 * Customer service for customer information
 * @author Madhur Toppo
 * @version 1.0
 * @since 15th March 2020
 */
@SpringBootApplication
@EntityScan(basePackages = "com.madhurtoppo.rentalcommons.model.customer")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableDiscoveryClient
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

}