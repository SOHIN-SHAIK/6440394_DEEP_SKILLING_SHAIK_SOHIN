package com.sohin.spring.controller;

import com.sohin.spring.entity.User;
import com.sohin.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserControllerPostTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Test User");

        when(userService.saveUser(user)).thenReturn(user);

        ResponseEntity<User> response = userController.createUser(user);

        assertThat(response.getBody().getName()).isEqualTo("Test User");
        verify(userService).saveUser(user);
    }
}
