package com.restapi.example.domain.article.controller;

import com.restapi.example.domain.article.entity.Article;
import com.restapi.example.domain.article.dto.ArticleDTO;
import com.restapi.example.domain.article.request.ArticleRequest;
import com.restapi.example.domain.article.response.ArticleResponse;
import com.restapi.example.domain.article.response.ArticlesResponse;
import com.restapi.example.domain.article.service.ArticleService;
import com.restapi.example.global.RsData.RsData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/articles")
@Tag(name = "ApiV1ArticleController", description = "게시글 CRUD API")
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping("")
    @Operation(summary = "게시글 다건 조회")
    @ResponseBody
    public /*ResponseEntity<List<ArticleDTO>>*/ RsData<ArticlesResponse> viewAll() {
        /*return ResponseEntity.ok(this.articleService.readAll().stream()
                .map(ArticleDTO::new).collect(Collectors.toList()));*/
        return RsData.of("200", "게시글 다건 조회 성공",
                new ArticlesResponse(this.articleService.readAll().stream()
                        .map(ArticleDTO::new).collect(Collectors.toList())));
    }

    @GetMapping("/{id}")
    @Operation(summary = "게시글 단건 조회")
    @ResponseBody
    public /*ResponseEntity<ArticleDTO>*/ RsData<ArticleResponse> viewOne(@PathVariable(value = "id") Long id) {
        Article article = this.articleService.readOne(id);
        if (article == null) {
            /*return ResponseEntity.badRequest().build();*/
            return RsData.of("500", "%d번 게시글은 존재하지 않습니다.".formatted(id));
        }
        /*return ResponseEntity.ok(new ArticleDTO(article));*/
        return RsData.of("200", "게시글 단건 조회 성공",
                new ArticleResponse(new ArticleDTO(article)));
    }

    @PostMapping("")
    @Operation(summary = "게시글 생성")
    @ResponseBody
    public ResponseEntity<ArticleDTO> /*RsData<ArticleResponse>*/ createOne(@Valid @RequestBody ArticleRequest articleRequest) {
        return ResponseEntity.created(URI.create("생성성공")).
                body(this.articleService.createOne(
                        articleRequest.getSubject(), articleRequest.getContent()
                ));
        /*return RsData.of("200", "게시글 생성 성공",
                new ArticleResponse(this.articleService.createOne(
                        articleRequest.getSubject(), articleRequest.getContent())));*/
    }

    @PatchMapping("/{id}")
    @Operation(summary = "게시글 수정")
    @ResponseBody
    public ResponseEntity<ArticleDTO> /*RsData<ArticleResponse>*/ modifyOne(@PathVariable(value = "id") Long id,
                                             @Valid @RequestBody ArticleRequest articleRequest) {
        Article article = this.articleService.readOne(id);
        if (article == null) {
            return ResponseEntity.badRequest().build();
            /*return RsData.of("500", "%d번 게시글은 존재하지 않습니다.".formatted(id));*/
        }

        return ResponseEntity.accepted().body(
                this.articleService.modifyOne(
                        article, articleRequest.getSubject(), articleRequest.getContent()
                ));
       /* return RsData.of("200", "게시글 수정 성공",
                new ArticleResponse(this.articleService.modifyOne(
                        article, articleRequest.getSubject(), articleRequest.getContent())));*/
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제")
    @ResponseBody
    public ResponseEntity<ArticleDTO> /*RsData<ArticleResponse>*/ deleteOne(@PathVariable(value = "id") Long id) {
        Article article = this.articleService.readOne(id);
        if (article == null) {
            return ResponseEntity.badRequest().build();
            /*return RsData.of("500", "%d번 게시글은 존재하지 않습니다.".formatted(id));*/
        }

        return ResponseEntity.accepted().body(this.articleService.deleteOne(article));
        /*return RsData.of("200", "게시글 삭제 성공",
                new ArticleResponse(this.articleService.deleteOne(article)));*/
    }
}
