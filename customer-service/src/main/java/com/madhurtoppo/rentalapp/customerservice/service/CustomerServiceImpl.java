package com.madhurtoppo.rentalapp.customerservice.service;

import com.madhurtoppo.rentalapp.customerservice.repository.CustomerRepository;
import com.madhurtoppo.rentalcommons.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/***
 * @author Madhur Toppo
 * @version 1.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer fetchById(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return customer.orElse(null);
    }

    @Override
    public List<Customer> fetchAllProfiles() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(int customerId) {
        customerRepository.deleteById(customerId);
    }
}
