package com.sohin.mockito;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        String data = api.getData();
        api.logAccess(data); // ✅ Required for interaction + call order tests
        return data;
    }

    public void logAccess(String user) {
        api.logAccess(user);
    }

    public void process(String msg) {
        api.sendData(msg); // ✅ Used in process-related tests
    }
}
