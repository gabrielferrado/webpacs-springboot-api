package com.webpacs.api.demo.user;

import com.webpacs.api.demo.DemoApplication;
import com.webpacs.api.demo.controllers.UserController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DemoApplication.class)
@WebMvcTest(UserController.class)
public class UserControllerTests {
  @Test
  void createAndRetrieveUser() {

  }
}
