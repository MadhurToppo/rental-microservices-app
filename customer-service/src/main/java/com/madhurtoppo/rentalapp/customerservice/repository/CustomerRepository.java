package com.madhurtoppo.rentalapp.customerservice.repository;

import com.madhurtoppo.rentalcommons.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * @author Madhur Toppo
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
