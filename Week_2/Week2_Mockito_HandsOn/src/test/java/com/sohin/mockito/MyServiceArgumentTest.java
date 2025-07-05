package com.sohin.mockito;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

public class MyServiceArgumentTest {
    @Test
    public void testArgumentMatcher() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        
        service.process("Hello World");

        verify(mockApi).sendData(argThat(msg -> msg.contains("Hello")));
    }
}
