package com.example.study.domain.post.service;

import com.example.study.domain.post.controller.dto.PostRequest;
import com.example.study.domain.post.controller.dto.PostResponse;
import com.example.study.domain.post.entity.PostEntity;
import com.example.study.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    // service에서만 repository를 접근할 수 있도록 설정
    private final PostRepository postRepository;

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

    public PostResponse findById(Long id) {
        PostEntity entity = postRepository.findById(id);

        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 id의 게시글이 존재하지 않습니다.");
        }

        return new PostResponse(entity);
    }

    public PostResponse update(Long id, PostRequest postRequest) {
        PostEntity entity = postRepository.findById(id);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "수정할 게시글이 없습니다.");
        }

        entity.update(postRequest.getTitle(), postRequest.getContent());
        return new PostResponse(entity);
    }

    public PostResponse delete(Long id) {
        PostEntity entity = postRepository.findById(id);

        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "삭제할 게시글이 없습니다.");
        }

        postRepository.delete(entity);
        return new PostResponse(entity);
    }
}



