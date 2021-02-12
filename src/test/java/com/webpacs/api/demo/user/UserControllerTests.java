package com.webpacs.api.demo.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webpacs.api.demo.controllers.UserController;
import com.webpacs.api.demo.models.User;
import com.webpacs.api.demo.repositories.UserRepository;
import com.webpacs.api.demo.services.UserDTO;
import com.webpacs.api.demo.services.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(UserController.class)
public class UserControllerTests {
  @Autowired MockMvc mockMvc;
  @MockBean private UserService userService;
  @Autowired private ObjectMapper objectMapper;

  private JacksonTester<UserDTO> jsonTester;
  private UserDTO userDto;

  @BeforeEach
  public void setup() {
    JacksonTester.initFields(this, objectMapper);
    userDto = new UserDTO();
  }

  @Test
  void createUserRequest() throws Exception {
    userDto.setId(1L);
    userDto.setName("Gabriel Ferrari");
    userDto.setEmail("gabriel@email.com");
    userDto.setPassword("123456");

    String userJson = jsonTester.write(userDto).getJson();

    mockMvc
        .perform(MockMvcRequestBuilders.post("/user")
        .content(userJson)
        .contentType(MediaType.APPLICATION_JSON)
      ).andExpect(status().isCreated()).andDo(print());
  }
}
