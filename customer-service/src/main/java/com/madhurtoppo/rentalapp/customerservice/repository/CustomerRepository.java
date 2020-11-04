package com.madhurtoppo.rentalapp.customerservice.repository;

import com.madhurtoppo.rentalcommons.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * @author Madhur Toppo
 * @version 1.0
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
