package com.restapi.example.article.controller;

import com.restapi.example.article.dto.ArticleDto;
import com.restapi.example.article.dto.ArticleRequest;
import com.restapi.example.article.dto.ArticleResponse;
import com.restapi.example.article.dto.ArticlesResponse;
import com.restapi.example.article.entity.Article;
import com.restapi.example.article.service.ArticleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
@Tag(name = "ApiV1ArticleController", description = "게시글 CRUD API")
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping("")
    public ResponseEntity<ArticlesResponse> readArticles() {
        return ResponseEntity.ok(
                new ArticlesResponse(
                        this.articleService.getAll().stream().map(ArticleDto::new).toList()
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readArticle(@PathVariable("id") Long id) {
        Article article = this.articleService.getOne(id);
        if (article == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("존재하지 않음");
        }
        return ResponseEntity.ok(new ArticleResponse(new ArticleDto(article)));
    }

    @PostMapping("")
    public ResponseEntity<?> createArticle(@Valid @RequestBody ArticleRequest articleRequest) {
        return ResponseEntity.ok(new ArticleResponse(new ArticleDto(
                this.articleService.create(articleRequest.getSubject(), articleRequest.getContent())
        )));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> modifyArticle(@PathVariable("id") Long id,
                                           @Valid @RequestBody ArticleRequest articleRequest) {
        Article article = this.articleService.getOne(id);
        if (article == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("존재하지 않음");
        }
        return ResponseEntity.ok(new ArticleResponse(new ArticleDto(
                this.articleService.modify(article, articleRequest.getSubject(), articleRequest.getContent())
        )));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable("id") Long id) {
        Article article = this.articleService.getOne(id);
        if (article == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("존재하지 않음");
        }
        return ResponseEntity.ok(new ArticleResponse(new ArticleDto(
                this.articleService.delete(article)
        )));
    }
}
