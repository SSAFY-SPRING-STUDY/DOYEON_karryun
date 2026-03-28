package com.example.study.controller.dto;

import lombok.Getter;

@Getter
public class PostRequest {
    private String title;
    private String content;
    private String author;

    @Override
    public String toString() {
        return "CreatePostRequest{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
