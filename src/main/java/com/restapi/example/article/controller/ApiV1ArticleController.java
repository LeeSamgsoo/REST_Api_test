package com.restapi.example.article.controller;

import com.restapi.example.article.dto.ArticleDTO;
import com.restapi.example.article.entity.Article;
import com.restapi.example.article.service.ArticleService;
import com.restapi.example.global.RsData.RsData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
    private final ArticleService articleService;
    private List<ArticleDTO> articleDTOList;

    @Getter
    @AllArgsConstructor
    public static class ArticlesResponse {
        private final List<ArticleDTO> articleList;
    }

    @Getter
    @AllArgsConstructor
    public static class ArticleResponse {
        private final ArticleDTO article;
    }

    @Data
    public static class ArticleRequest {
        @NotBlank
        private String subject;
        @NotBlank
        private String content;
    }

    @GetMapping("")
    public RsData<ArticlesResponse> list() {
        List<ArticleDTO> articleList = new ArrayList<>();

        Article article1 = new Article("제목1", "내용1");
        articleList.add(new ArticleDTO(article1));

        Article article2 = new Article("제목2", "내용2");
        articleList.add(new ArticleDTO(article2));

        Article article3 = new Article("제목3", "내용3");
        articleList.add(new ArticleDTO(article3));

        return RsData.of("200", "게시글 다건 조회 성공", new ArticlesResponse(articleList));
    }

    @GetMapping("/{id}")
    public RsData<ArticleResponse> getArticle(@PathVariable("id") Long id) {
        return RsData.of("200", "게시글 단건 조회 성공",
                new ArticleResponse(new ArticleDTO(new Article("제목1", "내용1"))));
    }

    @PostMapping("")
    public String create(@Valid @RequestBody ArticleRequest articleRequest) {
        System.out.println(articleRequest.getSubject());
        System.out.println(articleRequest.getContent());
        return "등록완료";
    }

    @PatchMapping("/{id}")
    public String modify(@PathVariable("id") Long id, @Valid @RequestBody ArticleRequest articleRequest) {
        System.out.println(id);
        System.out.println(articleRequest.getSubject());
        System.out.println(articleRequest.getContent());
        return "수정완료";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        System.out.println(id);
        return "삭제완료";
    }
}
