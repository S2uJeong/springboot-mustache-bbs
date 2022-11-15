package com.mustache.bbs.domain.entity;

import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;


@Getter
@Entity
@Table(name = "nation_wide_hospitals")
public class Hospital {
    @Id  // GeneratedValue 안씀
    private Integer id; // Long --> bigint

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "road_name_address")
    private String roadNameAddress;

    @Builder
    public Hospital(Integer id, String hospitalName, String roadNameAddress) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.roadNameAddress = roadNameAddress;
    }

    public Hospital() {

    }

    public static Hospital of(Integer id) {  // 정적메소드 만들기 안에 빌더??
        return Hospital.builder()
                .id(id).build();
    }

}
