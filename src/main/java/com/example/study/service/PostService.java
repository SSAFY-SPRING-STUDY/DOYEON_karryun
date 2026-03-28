package com.example.study.service;

import com.example.study.controller.dto.PostRequest;
import com.example.study.controller.dto.PostResponse;
import com.example.study.entity.PostEntity;
import com.example.study.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    // service에서만 repository를 접근할 수 있도록 설정
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponse save(PostRequest request) {
        PostEntity postEntity = new PostEntity(request.getTitle(), request.getContent(), request.getAuthor());

        PostEntity savedEntity = postRepository.save(postEntity);
        return new PostResponse(savedEntity);
    }

    public List<PostResponse> findAll() {
        List<PostEntity> entities = postRepository.findAll();

        List<PostResponse> postResponses = new ArrayList<>();

        for (PostEntity entity : entities) {
            PostResponse postResponse = new PostResponse(entity);
            postResponses.add(postResponse);
        }
        return postResponses;
    }
}



