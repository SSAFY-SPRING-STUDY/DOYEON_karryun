package com.example.study.component;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager {
    private final Map<String, Long> sessionStore = new ConcurrentHashMap<>();

    public String createSession(Long id) {
        String token = UUID.randomUUID().toString();
        sessionStore.put(token, id);
        return token;
    }

    public void removeSession(String accessToken) {
        sessionStore.remove(accessToken);
    }
}
