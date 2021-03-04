package com.madhurtoppo.rentalapp.rentalui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/***
 * Rent UI Client for Products Rental Application
 * @author Madhur Toppo
 * @since 15-March-2020
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RentalUiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RentalUiApplication.class, args);
    }
}
