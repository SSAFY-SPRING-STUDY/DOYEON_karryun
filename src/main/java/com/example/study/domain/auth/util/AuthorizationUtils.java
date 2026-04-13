package com.example.study.domain.auth.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorizationUtils {
    private static final String PREFIX = "Bearer ";

    public static String getAccessToken(String authHeader) {
        if (authHeader != null && authHeader.startsWith(PREFIX)) {
            return authHeader.substring(PREFIX.length());
        }
        throw new IllegalArgumentException("토큰에 문제가 있습니다.");
    }
}
