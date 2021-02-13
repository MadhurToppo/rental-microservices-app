package com.madhurtoppo.rentalapp.customerservice.service;

import com.madhurtoppo.rentalcommons.model.customer.Customer;

import java.util.List;

/***
 * @author Madhur Toppo
 * @since 15 March 2020
 */
public interface CustomerService {

    Customer save(Customer customer);

    Customer fetchById(int customerId);

    List<Customer> fetchAllProfiles();

    void delete(int customerId);
}
