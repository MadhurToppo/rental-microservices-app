package com.madhurtoppo.rentalcommons.model.product;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  private String make;
  private String model;
  private String type;
  private String category;
  private int year;

}