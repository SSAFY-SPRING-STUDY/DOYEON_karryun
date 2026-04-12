package com.example.study.domain.member.controller;

import com.example.study.domain.member.controller.dto.MemberRequest;
import com.example.study.domain.member.controller.dto.MemberResponse;
import com.example.study.domain.auth.service.AuthService;
import com.example.study.domain.member.service.MemberService;
import com.example.study.domain.auth.util.AuthorizationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<MemberResponse> join(@RequestBody MemberRequest request) {
        MemberResponse response = memberService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/me")
    public ResponseEntity<MemberResponse> me(@RequestHeader("Authorization") String authHeader) {
        MemberResponse response = null;

        try{
            String accessToken = AuthorizationUtils.getAccessToken(authHeader);
            long memberId = authService.getMemberId(accessToken);
            response = memberService.findById(memberId);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(response);
    }
}
