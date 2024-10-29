package com.restapi.example.article.service;

import com.restapi.example.article.dto.ArticleDTO;
import com.restapi.example.article.entity.Article;
import com.restapi.example.article.repository.ArticleRepository;
import com.restapi.example.article.request.ArticleCreateRequest;
import com.restapi.example.article.request.ArticleModifyRequest;
import com.restapi.example.global.RsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<ArticleDTO> getArticles() {
        List<Article> articleList = this.articleRepository.findAll();
        if (articleList.getFirst() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "없는 게시글");
        }
        return articleList.stream().map(ArticleDTO::new).collect(Collectors.toList());
    }

    public ArticleDTO getArticle(Long id) {
        Article article = this.articleRepository.findById(id).orElse(null);
        if (article == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "없는 게시글");
        }
        return new ArticleDTO(article);
    }

    public Article create(ArticleCreateRequest articleCreateRequest) {
        Article article = Article.builder()
                .subject(articleCreateRequest.getSubject())
                .content(articleCreateRequest.getContent())
                .build();
        this.articleRepository.save(article);
        return article;
    }

    public Article modify(Long id, ArticleModifyRequest articleModifyRequest) {
        Article article = this.articleRepository.findById(id).orElse(null);
        if (article == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "없는 게시글");
        }
        Article modifyArticle = article.toBuilder()
                .subject(articleModifyRequest.getSubject())
                .content(articleModifyRequest.getContent())
                .build();
        this.articleRepository.save(modifyArticle);
        return modifyArticle;
    }

    public Article delete(Long id) {
        Article article = this.articleRepository.findById(id).orElse(null);
        if (article == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "없는 게시글");
        }
        this.articleRepository.delete(article);
        return article;
    }

    public RsData<Article> write(String content, String subject) {
        Article article = Article.builder()
                .subject(subject)
                .content(content)
                .build();
        this.articleRepository.save(article);
        return RsData.of("200", "등록성공", article);
    }
}
