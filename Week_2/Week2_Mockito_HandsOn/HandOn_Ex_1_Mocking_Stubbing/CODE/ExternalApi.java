package com.sohin.mockito;

public interface ExternalApi {
    String getData();
    void logAccess(String user); // ✅ ADD THIS LINE
}
