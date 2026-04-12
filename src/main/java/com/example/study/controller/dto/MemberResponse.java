package com.example.study.controller.dto;

import com.example.study.entity.MemberEntity;

public record MemberResponse(
        Long id,
        String loginId,
        String name
) {
    public static MemberResponse fromEntity(MemberEntity entity) {
        return new MemberResponse(
                entity.getId(),
                entity.getLoginId(),
                entity.getName()
        );
    }
}