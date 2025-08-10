package com.sohin.mockito;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceInteractionTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        service.fetchData();

        verify(mockApi).getData();
        verify(mockApi).logAccess("Mock Data");
    }
}
