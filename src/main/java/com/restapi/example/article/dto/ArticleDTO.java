package com.restapi.example.article.dto;

import com.restapi.example.article.entity.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleDTO {
    private final Long id;
    private final String subject;
    private final String content;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public ArticleDTO(Article article) {
        this.id = article.getId();
        this.subject = article.getSubject();
        this.content = article.getContent();
        this.createdDate = article.getCreatedDate();
        this.modifiedDate = article.getModifiedDate();
    }
}
