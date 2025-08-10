package com.sohin.spring.integration;

import com.sohin.spring.SpringTestingApplication; // ✅ Add this import
import com.sohin.spring.entity.User;
import com.sohin.spring.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringTestingApplication.class // ✅ Specify explicitly
)
class UserIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFullFlow_fromControllerToDatabase() {
        // Arrange
        User user = new User(null, "Sohin");
        userRepository.save(user);

        // Act
        ResponseEntity<User> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/users/" + user.getId(),
                User.class
        );

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Sohin", response.getBody().getName());

        // Output path
        System.out.println("✅ Integration Test Passed");
        System.out.println("📂 Project Path: " + System.getProperty("user.dir"));
    }
}
