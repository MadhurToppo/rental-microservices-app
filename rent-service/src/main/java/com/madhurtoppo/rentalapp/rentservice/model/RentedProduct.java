package com.madhurtoppo.rentalapp.rentservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "rentedProduct")
@Data
public class RentedProduct {

  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  private int productId;

  private String make;

  private String model;

  private String type;
  private String category;
  private int year;

//  private int count;
}
