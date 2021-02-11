package com.webpacs.api.demo.controllers;

import com.webpacs.api.demo.models.User;
import com.webpacs.api.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/user/{id}")
  ResponseEntity<Optional<User>> getUser(@PathVariable String id) {
    return new ResponseEntity<>(userService.find(Long.parseLong(id, 10)), HttpStatus.OK);
  }
}
