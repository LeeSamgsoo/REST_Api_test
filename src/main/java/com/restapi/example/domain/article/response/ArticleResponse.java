package com.restapi.example.domain.article.response;

import com.restapi.example.domain.article.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleResponse {
    private final ArticleDTO article;
}
