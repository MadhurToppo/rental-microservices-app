package com.madhurtoppo.rentalapp.rentservice.controller;

import com.madhurtoppo.rentalapp.rentservice.service.RentService;
import com.madhurtoppo.rentalcommons.model.rent.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/***
 * @author Madhur Toppo
 * @version 1.0
 */
@RestController
@RequestMapping("/services/rents")
public class RentController {

    @Autowired
    RentService rentService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<Rent> getAllRents() {
        return rentService.findAll();
    }

    @PostMapping
    public Rent save(@RequestBody Rent rent) {
        return rentService.save(rent);
    }

    @GetMapping(value = "/{profileId}")
    public Rent fetch(@PathVariable int profileId) {
        return rentService.findById(profileId);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    //@PreAuthorize("hasRole('ROLE_admin')")
    public void delete(@PathVariable int id) {
        rentService.delete(id);
    }

    @GetMapping(value = "/monthData")
    public Map<String, Integer> monthlyData() {
        return rentService.getMonthlyData();
    }

    @GetMapping(value = "/productData")
    public List<Map<String, Object>> productData() {
        return rentService.getProductData();
    }

    @GetMapping(value = "/cityData")
    public List<Map<String, Object>> cityData() {
        return rentService.getCityData();
    }

}