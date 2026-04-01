package com.example.study.repository;

import com.example.study.entity.PostEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostRepository {
    // 창고가 계속 생기면 안되고 딱 1개만 생겨야 하니까 static final 붙이기
    private static final List<PostEntity> storage = new ArrayList<>();

    public PostEntity save(PostEntity entity) {
        storage.add(entity);
        return entity;
    }

    public List<PostEntity> findAll() {
        return storage;
    }

    public PostEntity findById(Long id) {
        for (PostEntity entity : storage) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    public void delete(PostEntity entity) {
        storage.remove(entity);
    }
}