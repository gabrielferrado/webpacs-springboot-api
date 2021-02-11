package com.webpacs.api.demo.services;

import com.webpacs.api.demo.models.User;
import com.webpacs.api.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
  private final UserRepository userRepository;


  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> find(Long id) {
    return userRepository.findById(id);
  }
}
