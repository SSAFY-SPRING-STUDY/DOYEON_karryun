package com.example.study.controller.dto;

public record LoginResponse(
        String accessToken,
        String tokenType
) {
}
