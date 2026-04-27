package com.example.study.domain.post.service;

import com.example.study.domain.member.repository.MemberRepository;
import com.example.study.domain.post.controller.dto.PostRequest;
import com.example.study.domain.post.controller.dto.PostResponse;
import com.example.study.domain.post.entity.PostEntity;
import com.example.study.domain.post.repository.PostRepository;
import com.example.study.global.error.CustomException;
import com.example.study.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    // service에서만 repository를 접근할 수 있도록 설정
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public PostResponse save(Long memberId, PostRequest request) {

        if(memberRepository.findById(memberId).isEmpty()) {
            throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);
        }

        PostEntity postEntity = new PostEntity(request.getTitle(), request.getContent(), memberId);

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
            throw new CustomException(ErrorCode.INVALID_PARAMETER);
        }

        return new PostResponse(entity);
    }

    public PostResponse update(Long id, PostRequest postRequest) {
        PostEntity entity = postRepository.findById(id);
        if (entity == null) {
            throw new CustomException(ErrorCode.INVALID_PARAMETER);
        }

        entity.update(postRequest.getTitle(), postRequest.getContent());
        return new PostResponse(entity);
    }

    public PostResponse delete(Long id) {
        PostEntity entity = postRepository.findById(id);

        if (entity == null) {
            throw new CustomException(ErrorCode.INVALID_PARAMETER);
        }

        postRepository.delete(entity);
        return new PostResponse(entity);
    }
}



