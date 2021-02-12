package com.webpacs.api.demo.controllers;

import com.webpacs.api.demo.models.User;
import com.webpacs.api.demo.services.UserDTO;
import com.webpacs.api.demo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
public class UserController {
  @Autowired private UserService userService;

  @GetMapping("/user/{id}")
  ResponseEntity<Optional<User>> getUser(@PathVariable String id) {
    return new ResponseEntity<>(userService.find(Long.parseLong(id, 10)), HttpStatus.OK);
  }

  @PostMapping("/user")
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public UserDTO createUser(@RequestBody UserDTO userDto) {
    User user = userService.convertToEntity(userDto);
    User createdUser = userService.createUser(user);
    return userService.convertToDto(createdUser);
  }
}
