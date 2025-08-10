package com.sohin.spring.controller;

import com.sohin.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerExceptionTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testUserNotFound() throws Exception {
        long testUserId = 999L;
        when(userService.getUserById(testUserId)).thenThrow(new NoSuchElementException("User not found"));

        System.out.println("Mock HTTP Request: GET /users/" + testUserId);

        MvcResult result = mockMvc.perform(get("/users/" + testUserId))
                .andExpect(status().isNotFound())
                .andReturn();

        int status = result.getResponse().getStatus();
        String body = result.getResponse().getContentAsString();

        System.out.println("Response Status: " + status + " NOT FOUND");
        System.out.println("Response Body: \"" + body + "\"");
        System.out.println();
        System.out.println("Performing GET /users/" + testUserId);
        System.out.println("Expected status: 404 Not Found");
        System.out.println("Returned body: " + body);
        System.out.println("Test passed.");
    }
}
