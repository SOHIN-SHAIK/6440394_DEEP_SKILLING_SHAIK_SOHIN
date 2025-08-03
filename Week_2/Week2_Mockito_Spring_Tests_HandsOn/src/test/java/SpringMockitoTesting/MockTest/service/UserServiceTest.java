package SpringMockitoTesting.MockTest.service;

import SpringMockitoTesting.MockTest.entity.User;
import SpringMockitoTesting.MockTest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserById() {
        User mockUser = new User();
        mockUser.setId(101L);
        mockUser.setName("Sohin");

        when(userRepository.findById(101L)).thenReturn(Optional.of(mockUser));

        User result = userService.getUserById(101L);

        assertEquals(101L, result.getId());
        assertEquals("Sohin", result.getName());
    }
}
