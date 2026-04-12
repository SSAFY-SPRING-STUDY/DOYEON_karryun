package com.example.study.controller.dto;

public record LoginRequest(
        String loginId,
        String password
) {
}
