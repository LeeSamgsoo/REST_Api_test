package com.restapi.example.domain.member.controller;

import com.restapi.example.domain.member.dto.MemberDTO;
import com.restapi.example.domain.member.entity.Member;
import com.restapi.example.domain.member.request.MemberRequest;
import com.restapi.example.domain.member.response.MemberResponse;
import com.restapi.example.domain.member.service.MemberService;
import com.restapi.example.global.RsData.RsData;
import com.restapi.example.global.jwt.JwtProvider;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


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
    public RsData<MemberResponse> login(@Valid @RequestBody MemberRequest memberRequest, HttpServletResponse resp) {
        Member member = this.memberService.getOne(memberRequest.getUsername());
        String accessToken = jwtProvider.genAccessToken(member);
        resp.addHeader("accessToken", accessToken);
        Cookie cookie = new Cookie("accessToken", accessToken);
        resp.addCookie(cookie);
        return RsData.of("200", accessToken, new MemberResponse(new MemberDTO(member)));
    }

    @GetMapping("/me")
    public RsData<MemberResponse> me(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        String accessToken = "";
        for (Cookie cookie : cookies) {
            if ("accessToken".equals(cookie.getName())) {
                accessToken = cookie.getValue();
            }
        }

        boolean checkedToken = jwtProvider.verify(accessToken);

        if (!checkedToken) {
            return RsData.of("500", "토큰이 유효하지 않습니다.", null);
        }

        Map<String, Object> claims = jwtProvider.getClaims(accessToken);
        String username = (String) claims.get("username");
        Member member = this.memberService.getOne(username);
        return RsData.of("200", accessToken, new MemberResponse(new MemberDTO(member)));
    }

    @GetMapping("/logout")
    public RsData<?> logout(HttpServletResponse res, HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        String accessToken = "";
        Cookie cookie = null;
        for (Cookie cook : cookies) {
            if ("accessToken".equals(cook.getName())) {
                accessToken = cook.getValue();
                cookie = cook;
            }
        }
        cookie.setMaxAge(0);
        cookie.setPath("/");
        res.addCookie(cookie);
        return RsData.of("200", "로그아웃 성공");
    }
}
