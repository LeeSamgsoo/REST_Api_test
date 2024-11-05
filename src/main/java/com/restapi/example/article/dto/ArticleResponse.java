package com.restapi.example.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleResponse {
    private ArticleDto article;
}
