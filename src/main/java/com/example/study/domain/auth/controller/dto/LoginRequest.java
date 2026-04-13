package com.example.study.domain.auth.controller.dto;

public record LoginRequest(
        String loginId,
        String password
) {
}
