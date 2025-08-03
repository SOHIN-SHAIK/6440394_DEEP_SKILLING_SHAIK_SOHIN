package com.sohin.spring.controller;

import com.sohin.spring.SpringTestingApplication;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@ContextConfiguration(classes = SpringTestingApplication.class)
public class UserControllerGetTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getUserByIdTest() throws Exception {
        User mockUser = new User(1L, "Sohin");

        // Mocking service method to return User, not Optional
        when(userService.getUserById(1L)).thenReturn(mockUser);

        mockMvc.perform(get("/users/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Sohin"));

        System.out.println("✔ getUserByIdTest() passed");
    }
}
