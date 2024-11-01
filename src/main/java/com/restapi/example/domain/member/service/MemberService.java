package com.restapi.example.domain.member.service;

import com.restapi.example.domain.member.entity.Member;
import com.restapi.example.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void join(String username, String password) {
        Member member = Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();
        this.memberRepository.save(member);
    }

    public Member getOne(Long id) {
        return this.memberRepository.findById(id).orElse(null);
    }
}
