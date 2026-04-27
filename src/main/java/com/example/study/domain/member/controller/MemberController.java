package com.example.study.domain.member.controller;

import com.example.study.domain.auth.service.AuthService;
import com.example.study.domain.auth.util.AuthorizationUtils;
import com.example.study.domain.member.controller.dto.MemberRequest;
import com.example.study.domain.member.controller.dto.MemberResponse;
import com.example.study.domain.member.service.MemberService;
import com.example.study.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final AuthService authService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<MemberResponse> join(@RequestBody MemberRequest request) {
        MemberResponse response = memberService.save(request);
        return ApiResponse.success(response);
    }

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<MemberResponse> me(@RequestHeader("Authorization") String authHeader) {
        String accessToken = AuthorizationUtils.getAccessToken(authHeader);

        long memberId = authService.getMemberId(accessToken);

        MemberResponse response = memberService.findById(memberId);

        return ApiResponse.success(response);
    }
}
