package com.webpacs.api.demo.user;

import com.webpacs.api.demo.models.User;
import com.webpacs.api.demo.repositories.UserRepository;
import com.webpacs.api.demo.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTests {
  @Autowired
  private UserRepository userRepository;

  @Test
  void createUser() {
    User user = new User("Gabriel", "gabriel@email.com", "1234");
    userRepository.save(user);

    UserService userService = new UserService(userRepository);
    Optional<User> foundUser = userService.find(user.getId());

    foundUser.ifPresent(u -> assertEquals(u.getId(), user.getId()));
  }
}
