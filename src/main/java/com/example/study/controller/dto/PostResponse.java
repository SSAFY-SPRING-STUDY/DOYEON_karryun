package com.example.study.controller.dto;

import com.example.study.entity.PostEntity;
import lombok.Getter;

@Getter
public class PostResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;

    public PostResponse(PostEntity postEntity) {
        this.id = postEntity.getId();
        this.title = postEntity.getTitle();
        this.content = postEntity.getContent();
        this.author = postEntity.getAuthor();
    }
}
