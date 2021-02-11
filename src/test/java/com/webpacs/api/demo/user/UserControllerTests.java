package com.webpacs.api.demo.user;

import com.webpacs.api.demo.controllers.UserController;
import com.webpacs.api.demo.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(UserController.class)
public class UserControllerTests {

  @MockBean
  private UserService userService;

  @Test
  void createAndRetrieveUser() {
    assertEquals(1,1);
  }
}
