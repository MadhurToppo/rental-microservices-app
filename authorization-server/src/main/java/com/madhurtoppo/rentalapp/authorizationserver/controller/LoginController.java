package com.madhurtoppo.rentalapp.authorizationserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

  @RequestMapping("/login")
  public String login() {
    return "login";
  }

//  @RequestMapping("/logout")
//  public String logout() {
//    return "You logged out from Authorization Server";
//  }
}
