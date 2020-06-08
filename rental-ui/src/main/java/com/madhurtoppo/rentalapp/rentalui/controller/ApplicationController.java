package com.madhurtoppo.rentalapp.rentalui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
//@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApplicationController {

  @Autowired
  RestTemplate restTemplate;

  @GetMapping("/index")
  public String goHome() {
    return "index";
  }

  @PostMapping("/logout")
  public void logout() {
  }

}
