package com.restapi.example.domain.member.service;

import com.restapi.example.domain.member.entity.Member;
import com.restapi.example.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void join(String username, String password) {
        Member member = Member.builder()
                .username(username)
                .password(password)
                .build();
        this.memberRepository.save(member);
    }
}
