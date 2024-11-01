package com.restapi.example.global.initData;

import com.restapi.example.domain.article.service.ArticleService;
import com.restapi.example.domain.member.entity.Member;
import com.restapi.example.domain.member.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Init {
    @Bean
    CommandLineRunner initData(ArticleService articleService, MemberService memberService) {

        return args -> {
            Member admin = memberService.join("admin", "1234");
            Member user1 = memberService.join("user1", "1234");
            Member user2 = memberService.join("user2", "1234");
            Member user3 = memberService.join("user3", "1234");
            Member user4 = memberService.join("user4", "1234");

            articleService.createOne("제목 1", "내용 1", admin);
            articleService.createOne("제목 2", "내용 2", admin);
            articleService.createOne("제목 3", "내용 3", user1);
            articleService.createOne("제목 4", "내용 4", user2);
            articleService.createOne("제목 5", "내용 5", user3);
            articleService.createOne("제목 6", "내용 6", user4);
        };
    }
}