package com.mustache.bbs.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Article {
    @Id  // Entity에는 대표값이 필요, 대표값을 지정 고유의 값
    @GeneratedValue(strategy = GenerationType.IDENTITY) // db에 id생성을 맡기겠다.
    private Long id;

    @Column  // DB에서 인식하게 칼럼을 붙여준다.
    private String title;
    @Column
    private String content;

    public Article( Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "";
    }
}
