package com.sohin.mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testMockingAndStubbing() {
        ExternalApi api = Mockito.mock(ExternalApi.class);
        when(api.getData()).thenReturn("Mocked Response");

        MyService service = new MyService(api);
        String result = service.fetchData();

        assertEquals("Mocked Response", result);
    }

    @Test
    public void testInteractionVerification() {
        ExternalApi api = mock(ExternalApi.class);
        MyService service = new MyService(api);

        service.fetchData();

        verify(api).getData();
    }

    @Test
    public void testArgumentMatching() {
        ExternalApi api = mock(ExternalApi.class);
        MyService service = new MyService(api);

        service.logAccess("sohin");

        verify(api).logAccess(eq("sohin"));
    }
}
