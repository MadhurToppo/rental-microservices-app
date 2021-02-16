package com.madhurtoppo.rentalapp.authorizationserver.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/***
 * @author Madhur Toppo
 * @since 15 March 2020
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

