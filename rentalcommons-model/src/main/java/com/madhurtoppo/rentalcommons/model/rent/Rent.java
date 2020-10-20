package com.madhurtoppo.rentalcommons.model.rent;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/***
 * @author Madhur Toppo
 * @since 28 March 2020
 */
@Entity
@Table(name = "Rent")
@Data
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int rentId;

    private int customerId;
    private int productId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentTill;

    private String rentLocation;

}
