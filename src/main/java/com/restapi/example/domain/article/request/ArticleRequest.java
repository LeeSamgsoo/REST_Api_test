package com.restapi.example.domain.article.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ArticleRequest {
    @NotBlank
    private String subject;

    @NotBlank
    private String content;
}
