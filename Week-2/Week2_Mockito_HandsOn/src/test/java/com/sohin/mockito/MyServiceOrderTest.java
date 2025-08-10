package com.sohin.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class MyServiceOrderTest {

   @Test
void testCallOrder() {
    ExternalApi externalApi = mock(ExternalApi.class);
    when(externalApi.getData()).thenReturn("Mocked");

    MyService service = new MyService(externalApi);

    service.fetchData();

    InOrder inOrder = inOrder(externalApi);
    inOrder.verify(externalApi).getData();
    inOrder.verify(externalApi).logAccess("Mocked");
}

}
