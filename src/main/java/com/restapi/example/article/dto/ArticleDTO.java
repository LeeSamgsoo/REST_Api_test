package com.restapi.example.article.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleDTO {
    private String subject;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public ArticleDTO(Article article) {
        this.subject = article.getSubject();
        this.content = article.getContent();
        this.createdDate = article.getCreatedDate();
        this.modifiedDate = article.getModifiedDate();
    }
}
