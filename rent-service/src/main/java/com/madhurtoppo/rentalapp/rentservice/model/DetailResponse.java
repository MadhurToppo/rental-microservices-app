package com.madhurtoppo.rentalapp.rentservice.model;

import com.madhurtoppo.rentalcommons.model.customer.Customer;
import com.madhurtoppo.rentalcommons.model.product.Product;
import com.madhurtoppo.rentalcommons.model.rent.Rent;

/***
 * @author Madhur Toppo
 * @since 15th March 2020
 */
public class DetailResponse implements Response {

    Rent rent;
    Customer customer;
    Product product;

    public DetailResponse(Rent rent, Customer customer, Product product) {
        this.rent = rent;
        this.customer = customer;
        this.product = product;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
