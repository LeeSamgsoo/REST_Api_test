package com.restapi.example.domain.member.repository;

import com.restapi.example.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);

    Optional<Member> findByRefreshToken(String refreshToken);
}
