package com.restapi.example.domain.member.response;

import com.restapi.example.domain.member.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberResponse {
    private final MemberDTO member;
}
