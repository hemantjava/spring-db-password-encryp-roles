package com.example.springinmemorypassword.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class WelcomeController {

  @GetMapping("/")
  public ResponseEntity getMessage(){
    return ResponseEntity.ok("<h1>Welcome</h2>");
  }

}
