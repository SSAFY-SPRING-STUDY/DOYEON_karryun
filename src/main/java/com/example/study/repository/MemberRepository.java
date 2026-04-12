package com.example.study.repository;

import com.example.study.entity.MemberEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemberRepository {
    private static Map<Long, MemberEntity> memberStore = new ConcurrentHashMap<>();

    public MemberEntity save(MemberEntity member) {
        memberStore.put(member.getId(), member);
        return member;
    }

    public Optional<MemberEntity> findByLoginId(String loginId) {
        for(MemberEntity entity : memberStore.values()){
            if(entity.getLoginId().equals(loginId)) {
                return Optional.of(entity);
            }
        }
        return Optional.empty();
    }
}
