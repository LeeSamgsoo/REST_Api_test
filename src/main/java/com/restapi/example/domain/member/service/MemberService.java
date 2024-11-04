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

    public Member join(String username, String password) {
        Member checkedMember = this.memberRepository.findByUsername(username);

        if (checkedMember != null) {
            throw new RuntimeException("이미 가입된 사용자입니다.");
        }

        Member member = Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();
        this.memberRepository.save(member);
        return member;
    }

    public Member getOne(String username) {
        Member member = this.memberRepository.findByUsername(username);
        if (member == null) {
            throw new RuntimeException("존재하지 않는 사용자입니다.");
        }
        /*if (!member.getPassword().equals(password)) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }*/
        return member;
    }
}
