package com.restapi.example.domain.article.entity;

import com.restapi.example.domain.member.entity.Member;
import com.restapi.example.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
public class Article extends BaseEntity {
    private String subject;
    private String content;
    @ManyToOne
    private Member member;
}
