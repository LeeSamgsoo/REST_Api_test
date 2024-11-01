package com.restapi.example.domain.member.controller;

import com.restapi.example.domain.member.service.MemberService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/articles")
@Tag(name = "ApiV1MemberController", description = "게시글 CRUD API")
public class ApiV1MemberController {
    private final MemberService articleService;
}
