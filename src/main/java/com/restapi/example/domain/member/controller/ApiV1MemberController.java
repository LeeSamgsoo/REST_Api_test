package com.restapi.example.domain.member.controller;

import com.restapi.example.domain.member.dto.MemberDTO;
import com.restapi.example.domain.member.entity.Member;
import com.restapi.example.domain.member.request.MemberRequest;
import com.restapi.example.domain.member.response.MemberResponse;
import com.restapi.example.domain.member.service.MemberService;
import com.restapi.example.global.jwt.JwtProvider;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    private final JwtProvider jwtProvider;

    @PostMapping("/join")
    public ResponseEntity<MemberResponse> join(@Valid @RequestBody MemberRequest memberRequest) {
        return ResponseEntity.ok(new MemberResponse(new MemberDTO(
                this.memberService.join(memberRequest.getUsername(), memberRequest.getPassword())
        )));
    }

    @PostMapping("/login")
    public String login() {
        Member member = memberService.getOne("admin");
        return jwtProvider.generateAccessToken(member, 10);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession httpSession) {
        httpSession.invalidate();
        return ResponseEntity.ok("로그아웃 성공");
    }
}
