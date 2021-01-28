package com.madhurtoppo.rentalapp.authorizationserver.model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/***
 * @author Madhur Toppo
 * @version 1.0
 * @since 15 March 2020
 */

@Entity
@Table(name = "role")
@Data
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission_role", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private List<Permission> permissions;

}
