package com.example.study.service;

import com.example.study.controller.dto.MemberRequest;
import com.example.study.controller.dto.MemberResponse;
import com.example.study.entity.MemberEntity;
import com.example.study.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberResponse save(MemberRequest request) {
        MemberEntity entity = MemberRequest.toEntity(request);
        MemberEntity savedEntity = memberRepository.save(entity);

        return MemberResponse.fromEntity(savedEntity);
    }
}
