package com.restapi.example.domain.member.controller;

import com.restapi.example.domain.member.request.MemberRequest;
import com.restapi.example.domain.member.service.MemberService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/members")
@Tag(name = "ApiV1MemberController", description = "회원 인증인가 API")
public class ApiV1MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    public String join(@Valid @RequestBody MemberRequest memberRequest) {
        this.memberService.join(memberRequest.getUsername(), memberRequest.getPassword());
        return "성공";
    }
}
