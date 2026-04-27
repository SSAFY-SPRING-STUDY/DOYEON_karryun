package com.example.study.domain.post.controller;

import com.example.study.domain.post.controller.dto.PostRequest;
import com.example.study.domain.post.controller.dto.PostResponse;
import com.example.study.domain.post.service.PostService;
import com.example.study.global.common.ApiResponse;
import com.example.study.global.error.CustomException;
import com.example.study.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/posts")
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시글 생성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<PostResponse> createPost(
            @RequestHeader(value = "Authorization", required = false) String token,
            @RequestBody PostRequest request) {

        if (token == null || token.isEmpty()) {
            throw new CustomException(ErrorCode.UNAUTHORIZED);
        }

        Long memberId = Long.valueOf(token);

        PostResponse response = postService.save(memberId, request);

        return ApiResponse.success(response);
    }

    // 게시글 전체 목록 조회
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<PostResponse>> findAllPosts() {
        List<PostResponse> response = postService.findAll();
        return ApiResponse.success(response);
    }

    // 특정 게시글 상세 조회
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PostResponse> findPostById(@PathVariable Long id) { // {id} 이거 가져와야 함
        PostResponse response = postService.findById(id);
        return ApiResponse.success(response);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PostResponse> updatePost(@PathVariable Long id, @RequestBody PostRequest postRequest) {
        PostResponse response = postService.update(id, postRequest);
        return ApiResponse.success(response);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PostResponse> deletePost(@PathVariable Long id) {
        PostResponse response = postService.delete(id);
        return ApiResponse.success(response);
    }

}
