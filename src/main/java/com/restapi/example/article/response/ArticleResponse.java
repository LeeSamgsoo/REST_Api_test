package com.restapi.example.article.response;

import com.restapi.example.article.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleResponse {
    private final ArticleDTO article;
}
