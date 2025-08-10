package SpringMockitoTesting.MockTest.controller;

import SpringMockitoTesting.MockTest.entity.User;
import SpringMockitoTesting.MockTest.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetUser() {
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("Sohin");

        when(userService.getUserById(1L)).thenReturn(mockUser);

        ResponseEntity<User> response = userController.getUser(1L);
        User result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("Sohin", result.getName());
    }
}
