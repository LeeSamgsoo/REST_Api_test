package com.restapi.example.global.initData;

import com.restapi.example.domain.article.service.ArticleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Init {
    @Bean
    CommandLineRunner initData(ArticleService articleService) {

        return args -> {
            articleService.createOne("제목 1", "내용 1");
            articleService.createOne("제목 2", "내용 2");
            articleService.createOne("제목 3", "내용 3");
            articleService.createOne("제목 4", "내용 4");
            articleService.createOne("제목 5", "내용 5");
            articleService.createOne("제목 6", "내용 6");
        };
    }
}
