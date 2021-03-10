package com.madhurtoppo.rentalapp.authorizationserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * @author Madhur Toppo
 * @since 15th March 2020
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
