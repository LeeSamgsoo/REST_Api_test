package com.restapi.example.article.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.restapi.example.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
public class Article extends BaseEntity {
    private String subject;
    private String content;
}
