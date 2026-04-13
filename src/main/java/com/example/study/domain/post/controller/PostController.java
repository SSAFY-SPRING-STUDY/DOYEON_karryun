package com.example.study.domain.post.controller;

import com.example.study.domain.post.controller.dto.PostRequest;
import com.example.study.domain.post.controller.dto.PostResponse;
import com.example.study.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/posts")
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시글 생성
    @PostMapping
    public PostResponse createPost(@RequestBody PostRequest request) {
        PostResponse response = postService.save(request);
        return response;
    }

    // 게시글 전체 목록 조회
    @GetMapping
    public List<PostResponse> findAllPosts() {
        return postService.findAll();
    }

    // 특정 게시글 상세 조회
    @GetMapping("/{id}")
    public PostResponse findPostById(@PathVariable Long id) { // {id} 이거 가져와야 함
        return postService.findById(id);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public PostResponse updatePost(@PathVariable Long id, @RequestBody PostRequest postRequest) {
        return postService.update(id, postRequest);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public PostResponse deletePost(@PathVariable Long id) {
        return postService.delete(id);
    }

}
