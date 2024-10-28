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
    private List<ArticleDTO> articleDTOList;

    @GetMapping("")
    public List<ArticleDTO> list() {
        articleDTOList = new ArrayList<>();
        articleDTOList.add(new ArticleDTO(new Article("제목1", "내용1")));
        articleDTOList.add(new ArticleDTO(new Article("제목2", "내용2")));
        articleDTOList.add(new ArticleDTO(new Article("제목3", "내용3")));

        return articleDTOList;
    }

    @GetMapping("/{id}")
    public ArticleDTO getArticle(@PathVariable("id") Long id) {
        return articleDTOList.get(Math.toIntExact(id));
    }

    @PostMapping("")
    public ArticleDTO create(@RequestParam("subject") String subject,
                         @RequestParam("content") String content) {
        return new ArticleDTO(new Article(subject, content));
    }

    @PatchMapping("/{id}")
    public String modify(@RequestParam("subject") String subject,
                         @RequestParam("content") String content,
                         @PathVariable("id") Long id) {
        System.out.println(subject);
        System.out.println(content);
        return id + "번 수정성공";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        System.out.println(id + "삭제 됨");
        return id + "번 삭제성공";
    }
}
