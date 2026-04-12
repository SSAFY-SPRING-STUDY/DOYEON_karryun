package com.example.study.controller.dto;

import com.example.study.entity.MemberEntity;

public record MemberRequest(
         String loginId,
         String password,
         String name
) {
    public static MemberEntity toEntity(MemberRequest request) {
        return new MemberEntity(
                request.loginId(),
                request.password(),
                request.name()
        );
    }
}
