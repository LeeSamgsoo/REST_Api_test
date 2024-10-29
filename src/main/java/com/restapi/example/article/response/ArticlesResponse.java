package com.restapi.example.article.response;

import com.restapi.example.article.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ArticlesResponse {
    private final List<ArticleDTO> articleList;
}
