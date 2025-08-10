package com.sohin.mockito;

public interface ExternalApi {
    String getData();
    void logAccess(String data);
    void sendData(String message);
}
