package SpringMockitoTesting.MockTest.controller;

import SpringMockitoTesting.MockTest.entity.User;
import SpringMockitoTesting.MockTest.service.UserService;
import SpringMockitoTesting.MockTest.controller.UserController; // ✅ Add this if not already
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class) // ✅ Ensure UserController exists in same package or imported
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUser() throws Exception {
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("Sohin");

        Mockito.when(userService.getUserById(1L)).thenReturn(mockUser);

        mockMvc.perform(get("/user/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Sohin"));
    }
}
