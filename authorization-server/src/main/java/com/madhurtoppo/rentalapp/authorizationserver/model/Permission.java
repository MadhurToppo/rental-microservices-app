package com.madhurtoppo.rentalapp.authorizationserver.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/***
 * @author Madhur Toppo
 * @version 1.0
 * @since 28 March 2020
 */

@Entity
@Table(name = "permission")
@Data
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
}

