package com.madhurtoppo.rentalcommons.model.customer;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;

/***
 * @author Madhur Toppo
 * @version 1.0
 */
@Entity
@Table(name = "Customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int customerId;

    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private String idNumber;
    private String address;
    private String phoneNumber;

}