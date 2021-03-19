package com.madhurtoppo.rentalapp.rentservice.model;

import com.madhurtoppo.rentalcommons.model.rent.Rent;

/***
 * @author Madhur Toppo
 * @since 15th March 2020
 */
public class SimpleResponse implements Response {

    Rent rent;

    public SimpleResponse(Rent rent) {
        this.rent = rent;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }
}
