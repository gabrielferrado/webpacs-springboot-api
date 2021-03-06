package com.webpacs.api.demo.services;

import com.webpacs.api.demo.models.User;
import com.webpacs.api.demo.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
  @Autowired private PasswordEncoder passwordEncoder;
  @Autowired private ModelMapper modelMapper;

  private final UserRepository userRepository;

  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  Date date = new Date();

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User convertToEntity(UserDTO userDTO) {
    return modelMapper.map(userDTO, User.class);
  }

  public UserDTO convertToDto(User user) {
    return modelMapper.map(user, UserDTO.class);
  }

  public Optional<User> find(Long id) {
    return userRepository.findById(id);
  }

  public User createUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRememberToken(passwordEncoder.encode(formatter.format(date)));
    return userRepository.save(user);
  }
}
