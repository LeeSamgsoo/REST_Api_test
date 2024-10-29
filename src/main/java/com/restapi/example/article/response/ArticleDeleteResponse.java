package com.restapi.example.article.response;

import com.restapi.example.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleDeleteResponse {
    private final Article article;
}
