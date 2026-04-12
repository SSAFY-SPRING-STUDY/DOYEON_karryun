package com.example.study.controller;

import com.example.study.controller.dto.MemberRequest;
import com.example.study.controller.dto.MemberResponse;
import com.example.study.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberResponse> join(@RequestBody MemberRequest request) {
        MemberResponse response = memberService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
