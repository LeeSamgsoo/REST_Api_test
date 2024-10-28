package com.restapi.example.article.controller;

import com.restapi.example.article.dto.ArticleDTO;
import com.restapi.example.article.entity.Article;
import com.restapi.example.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping("")
    public List<ArticleDTO> list() {
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        articleDTOList.add(new ArticleDTO(new Article("제목1", "내용1")));
        articleDTOList.add(new ArticleDTO(new Article("제목2", "내용2")));
        articleDTOList.add(new ArticleDTO(new Article("제목3", "내용3")));

        return articleDTOList;
    }

    @GetMapping("/{id}")
    public ArticleDTO getArticle() {
        return new ArticleDTO(new Article("제목", "내용"));
    }

    @PostMapping("")
    public String create() {
        return "";
    }

    @PatchMapping("/{id}")
    public String modify() {
        return "";
    }

    @DeleteMapping("/{id}")
    public String delete() {
        return "";
    }
}
