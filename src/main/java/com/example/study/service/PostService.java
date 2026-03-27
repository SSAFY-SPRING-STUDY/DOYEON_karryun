package com.example.study.service;

import com.example.study.controller.dto.CreatePostRequest;
import com.example.study.controller.dto.PostResponse;
import com.example.study.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponse save(CreatePostRequest request) {
        postRepository.save
    }
}



