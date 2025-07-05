package com.sohin.mockito;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceVoidTest {

    @Test
    void testStubVoidMethod() {
        ExternalApi externalApi = mock(ExternalApi.class);
        // Stubbing the void method
        doNothing().when(externalApi).logAccess(anyString());

        MyService service = new MyService(externalApi);
        service.logAccess("Sohin"); // This will NOT throw any exception
        verify(externalApi).logAccess("Sohin"); // Verification
    }
}
