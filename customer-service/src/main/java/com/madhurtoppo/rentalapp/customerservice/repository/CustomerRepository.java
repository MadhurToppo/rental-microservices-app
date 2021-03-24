package com.madhurtoppo.rentalapp.customerservice.repository;

import com.madhurtoppo.rentalcommons.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * @author Madhur Toppo
 * @since 15th March 2020
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
