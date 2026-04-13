package com.example.study.domain.auth.controller.dto;

public record LoginResponse(
        String accessToken,
        String tokenType
) {
}
