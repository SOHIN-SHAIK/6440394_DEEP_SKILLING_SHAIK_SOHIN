package com.sohin.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sohin.spring.entity.User;
import com.sohin.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.sohin.spring.SpringTestingApplication;

@WebMvcTest(UserController.class)
@ContextConfiguration(classes = SpringTestingApplication.class)
public class UserControllerPostTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private final ObjectMapper objectMapper = new ObjectMapper(); // ✅ use this if @Autowired fails

    @Test
    void createUserTest() throws Exception {
        User inputUser = new User(null, "Sohin");
        User savedUser = new User(1L, "Sohin");

        Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(savedUser);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Sohin"));
    }
}
