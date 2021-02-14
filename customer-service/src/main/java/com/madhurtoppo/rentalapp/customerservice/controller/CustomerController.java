package com.madhurtoppo.rentalapp.customerservice.controller;

import com.madhurtoppo.rentalapp.customerservice.service.CustomerService;
import com.madhurtoppo.rentalcommons.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * @author Madhur Toppo
 * @since 15 March 2020
 */
@RestController
@RequestMapping(value = "/services")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping(value = "/customer/{profileId}")
    public Customer fetch(@PathVariable int profileId) {
        return customerService.fetchById(profileId);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<Customer> fetch() {
        return customerService.fetchAllProfiles();
    }

    @RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.DELETE)
    //@PreAuthorize("hasRole('ROLE_admin')")
    public void delete(@PathVariable int id) {
        customerService.delete(id);
    }

    @GetMapping(value = "/hi")
    public String hi() {
        return "Hi";
    }

}
