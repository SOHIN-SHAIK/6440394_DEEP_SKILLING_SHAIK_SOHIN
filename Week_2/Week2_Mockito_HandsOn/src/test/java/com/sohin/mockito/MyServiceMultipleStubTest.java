package com.sohin.mockito;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceMultipleStubTest {

    @Test
    void testMultipleReturns() {
        ExternalApi externalApi = mock(ExternalApi.class);
        when(externalApi.getData())
            .thenReturn("First Call")
            .thenReturn("Second Call");

        MyService service = new MyService(externalApi);

        assertEquals("First Call", service.fetchData());
        assertEquals("Second Call", service.fetchData());

        verify(externalApi, times(2)).getData();
    }
}
