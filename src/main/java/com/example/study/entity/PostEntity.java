package com.example.study.entity;

import lombok.Getter;

@Getter
public class PostEntity {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostEntity(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
