package com.restapi.example.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ArticlesResponse {
    private List<ArticleDto> articleList;
}
