package com.example.study.service;

import com.example.study.component.SessionManager;
import com.example.study.controller.dto.LoginRequest;
import com.example.study.controller.dto.LoginResponse;
import com.example.study.entity.MemberEntity;
import com.example.study.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final SessionManager sessionManager;
    private final MemberRepository memberRepository;

    public LoginResponse login(LoginRequest request) {
        MemberEntity member = memberRepository.findByLoginId(request.loginId())
                .orElseThrow(() -> new RuntimeException("아이디가 올바르지 않습니다."));

        if(member.isVAlidPassword(request.password())){
            String token = sessionManager.createSession(member.getId());
            return new LoginResponse(token, "Bearer");
        }
        throw new RuntimeException("비밀번호가 올바르지 않습니다.");
    }

    public void logout(String accessToken) {
        sessionManager.removeSession(accessToken);
    }
}
