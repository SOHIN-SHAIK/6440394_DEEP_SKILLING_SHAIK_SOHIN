package com.sohin.mockito;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultiReturnServiceTest {
    @Test
    public void testServiceWithMultipleReturnValues() {
        Repository mockRepository = mock(Repository.class);
        when(mockRepository.getData())
            .thenReturn("First Mock Data")
            .thenReturn("Second Mock Data");

        Service service = new Service(mockRepository);
        String first = service.processData();
        String second = service.processData();

        assertEquals("Processed First Mock Data", first);
        assertEquals("Processed Second Mock Data", second);
    }
}
