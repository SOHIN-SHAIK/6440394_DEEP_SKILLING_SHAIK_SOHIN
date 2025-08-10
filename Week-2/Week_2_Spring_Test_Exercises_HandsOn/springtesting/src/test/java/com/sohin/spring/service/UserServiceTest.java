package com.sohin.spring.service;

import com.sohin.spring.entity.User;
import com.sohin.spring.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository mockRepo;
    private UserService userService;

    @BeforeEach
    void setUp() {
        mockRepo = Mockito.mock(UserRepository.class);
        userService = new UserService(mockRepo);
    }

    @Test
    void testSaveUser() {
        User user = new User(null, "Sohin");
        User savedUser = new User(1L, "Sohin");

        when(mockRepo.save(user)).thenReturn(savedUser);

        User result = userService.saveUser(user);

        assertEquals(1L, result.getId());
        assertEquals("Sohin", result.getName());

        System.out.println("✔ testSaveUser() passed");
    }

    @Test
    void testGetUserById() {
        User user = new User(1L, "Sohin");

        when(mockRepo.findById(1L)).thenReturn(java.util.Optional.of(user));

        User result = userService.getUserById(1L); // return type is User

        assertNotNull(result);
        assertEquals("Sohin", result.getName());

        System.out.println("✔ testGetUserById() passed");
    }
}
