package com.restapi.example.article.dto;

import com.restapi.example.article.entity.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleDto {
    private Long id;
    private String subject;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public ArticleDto(Article article) {
        this.id = article.getId();
        this.subject = article.getSubject();
        this.content = article.getContent();
        this.createdDate = article.getCreatedDate();
        this.modifiedDate = article.getModifiedDate();
    }
}
