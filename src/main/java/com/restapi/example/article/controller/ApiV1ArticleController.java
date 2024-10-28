package com.restapi.example.article.controller;

import com.restapi.example.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping("")
    @ResponseBody
    public String list() {
        return "목록";
    }

    @GetMapping("/{id}")
    public String getArticle() {
        return "";
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
