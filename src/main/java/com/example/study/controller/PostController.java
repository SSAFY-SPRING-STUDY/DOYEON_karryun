package com.example.study.controller;

import com.example.study.controller.dto.PostRequest;
import com.example.study.controller.dto.PostResponse;
import com.example.study.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시글 생성
    @PostMapping("/api/posts")
    public PostResponse createPost(@RequestBody PostRequest request) {

        PostResponse response = postService.save(request);

        return response;
    }

    // 게시글 전체 목록 조회
    @GetMapping("/api/posts")
    public List<PostResponse> findAllPosts() {
        return postService.findAll();
    }
}
