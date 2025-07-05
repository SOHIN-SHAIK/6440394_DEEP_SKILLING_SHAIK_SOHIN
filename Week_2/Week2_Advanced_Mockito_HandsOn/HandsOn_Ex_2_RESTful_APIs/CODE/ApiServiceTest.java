package com.sohin.mockito;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApiServiceTest {
    @Test
    public void testServiceWithMockRestClient() {
        RestClient mockClient = mock(RestClient.class);
        when(mockClient.getResponse()).thenReturn("Mock Response");

        ApiService apiService = new ApiService(mockClient);
        String result = apiService.fetchData();

        assertEquals("Fetched Mock Response", result);
    }
}
