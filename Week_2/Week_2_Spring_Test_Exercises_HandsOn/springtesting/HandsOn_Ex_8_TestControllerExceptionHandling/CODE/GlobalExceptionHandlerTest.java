package com.sohin.spring.exceptionhandler;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class GlobalExceptionHandlerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testNotFoundExceptionHandled() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/99999"))
               .andExpect(status().isNotFound())
               .andExpect(content().string("User not found"));
    }
}
