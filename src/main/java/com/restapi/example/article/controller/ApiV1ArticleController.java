package com.restapi.example.article.controller;

import com.restapi.example.article.entity.Article;
import com.restapi.example.article.request.ArticleCreateRequest;
import com.restapi.example.article.request.ArticleModifyRequest;
import com.restapi.example.article.response.*;
import com.restapi.example.article.service.ArticleService;
import com.restapi.example.global.RsData.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping("")
    public RsData<ArticlesResponse> list() {
        return RsData.of("200", "게시글 다건 조회 성공",
                new ArticlesResponse(this.articleService.getArticles()));
    }

    @GetMapping("/{id}")
    public RsData<ArticleResponse> getArticle(@PathVariable("id") Long id) {
        return RsData.of("200", "게시글 단건 조회 성공",
                new ArticleResponse(this.articleService.getArticle(id)));
    }

    @PostMapping("")
    public RsData<ArticleCreateResponse> create(@Valid @RequestBody ArticleCreateRequest articleCreateRequest) {
        Article article = this.articleService.create(articleCreateRequest);
        return RsData.of("200", "등록성공", new ArticleCreateResponse(article));
    }

    @PatchMapping("/{id}")
    public RsData<ArticleModifyResponse> modify(@PathVariable("id") Long id, @Valid @RequestBody ArticleModifyRequest articleModifyRequest) {
        Article article = this.articleService.modify(id, articleModifyRequest);
        return RsData.of("200", "수정성공", new ArticleModifyResponse(article));
    }

    @DeleteMapping("/{id}")
    public RsData<ArticleDeleteResponse> delete(@PathVariable("id") Long id) {
        Article article = this.articleService.delete(id);
        return RsData.of("200","삭제성공",new ArticleDeleteResponse(article));
    }
}
