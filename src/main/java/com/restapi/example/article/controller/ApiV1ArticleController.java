package com.restapi.example.article.controller;

import com.restapi.example.article.dto.ArticleDTO;
import com.restapi.example.article.entity.Article;
import com.restapi.example.article.request.ArticleCreateRequest;
import com.restapi.example.article.request.ArticleModifyRequest;
import com.restapi.example.article.response.ArticleResponse;
import com.restapi.example.article.response.ArticlesResponse;
import com.restapi.example.article.service.ArticleService;
import com.restapi.example.global.RsData.RsData;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
    private final ArticleService articleService;

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
    public String create(@Valid @RequestBody ArticleCreateRequest articleCreateRequest) {
        System.out.println(articleCreateRequest.getSubject());
        System.out.println(articleCreateRequest.getContent());
        return "등록완료";
    }

    @PatchMapping("/{id}")
    public String modify(@PathVariable("id") Long id, @Valid @RequestBody ArticleModifyRequest articleModifyRequest) {
        System.out.println(id);
        System.out.println(articleModifyRequest.getSubject());
        System.out.println(articleModifyRequest.getContent());
        return "수정완료";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        System.out.println(id);
        return "삭제완료";
    }
}
