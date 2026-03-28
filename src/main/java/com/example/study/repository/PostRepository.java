package com.example.study.repository;

import com.example.study.entity.PostEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    // 창고가 계속 생기면 안되고 딱 1개만 생겨야 하니까 static 붙이기
    private static final List<PostEntity> store = new ArrayList<>();
    private static Long sequence = 0L;

    public PostEntity save(PostEntity entity) {
        sequence++;
        entity.setId(sequence);
        store.add(entity);
        return entity;
    }

    public List<PostEntity> findAll() {
    }
}
