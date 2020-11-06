package com.madhurtoppo.rentalapp.rentservice.model;

import lombok.Data;

import javax.persistence.*;

/***
 * @author Madhur Toppo
 * @version 1.0
 */
@Entity
@Table(name = "RentedProduct")
@Data
public class RentedProduct {

    @Id
    int rentId;

    private int productId;
    private String make;
    private String model;
    private String type;
    private String category;
    private int year;

}
