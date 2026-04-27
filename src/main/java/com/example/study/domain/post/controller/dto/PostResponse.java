package com.example.study.domain.post.controller.dto;

import com.example.study.domain.post.entity.PostEntity;
import lombok.Getter;

@Getter
public class PostResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final Long authorId;

    public PostResponse(PostEntity postEntity) {
        this.id = postEntity.getId();
        this.title = postEntity.getTitle();
        this.content = postEntity.getContent();
        this.authorId = postEntity.getAuthorId();
    }
}
