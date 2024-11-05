package com.restapi.example.article.service;

import com.restapi.example.article.entity.Article;
import com.restapi.example.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getAll() {
        return this.articleRepository.findAll();
    }

    public Article getOne(Long id) {
        return this.articleRepository.findById(id).orElse(null);
    }

    public Article create(String subject, String content) {
        Article article = Article.builder()
                .subject(subject)
                .content(content)
                .build();
        this.articleRepository.save(article);
        return article;
    }

    public Article modify(Article article, String subject, String content) {
        Article modArticle = article.toBuilder()
                .subject(subject)
                .content(content)
                .build();
        this.articleRepository.save(modArticle);
        return modArticle;
    }

    public Article delete(Article article) {
        this.articleRepository.delete(article);
        return article;
    }
}
