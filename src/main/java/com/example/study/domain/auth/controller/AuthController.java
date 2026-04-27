package com.example.study.domain.auth.controller;

import com.example.study.domain.auth.controller.dto.LoginRequest;
import com.example.study.domain.auth.controller.dto.LoginResponse;
import com.example.study.domain.auth.service.AuthService;
import com.example.study.domain.auth.util.AuthorizationUtils;
import com.example.study.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);

        return ApiResponse.success(response);
    }
    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Void> logout(@RequestHeader("Authorization") String authHeader) {
        String accessToken = AuthorizationUtils.getAccessToken(authHeader);
        authService.logout(accessToken);

        return ApiResponse.success();
    }
}
