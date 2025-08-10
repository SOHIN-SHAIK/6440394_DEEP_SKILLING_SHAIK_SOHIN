package com.sohin.mockito;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public void logAccess(String user) {
        api.logAccess(user);
    }
}
