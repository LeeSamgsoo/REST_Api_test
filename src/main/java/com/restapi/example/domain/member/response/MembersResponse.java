package com.restapi.example.domain.member.response;

import com.restapi.example.domain.member.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MembersResponse {
    private final List<MemberDTO> memberList;
}
