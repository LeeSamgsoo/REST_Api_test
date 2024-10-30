package com.restapi.example.article.service;

import com.restapi.example.article.dto.Article;
import com.restapi.example.article.dto.ArticleDTO;
import com.restapi.example.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> readAll() {
        return this.articleRepository.findAll();
    }

    public Article readOne(Long id) {
        return this.articleRepository.findById(id).orElse(null);
    }

    public ArticleDTO createOne(String subject, String content) {
        Article article = Article.builder()
                .subject(subject)
                .content(content)
                .build();
        this.articleRepository.save(article);
        return new ArticleDTO(article);
    }

    public ArticleDTO modifyOne(Article article, String subject, String content) {
        Article modifiedArticle = article.toBuilder()
                .subject(subject)
                .content(content)
                .build();
        this.articleRepository.save(modifiedArticle);
        return new ArticleDTO(modifiedArticle);
    }

    public ArticleDTO deleteOne(Article article) {
        this.articleRepository.delete(article);
        return new ArticleDTO(article);
    }
}
