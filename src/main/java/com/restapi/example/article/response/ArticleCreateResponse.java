package com.restapi.example.article.response;

import com.restapi.example.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleCreateResponse {
    private final Article article;
}
