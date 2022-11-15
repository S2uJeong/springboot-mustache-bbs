package com.mustache.bbs.domain.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "nation_wide_hospitals")
public class Hospital {
    @Id  // GeneratedValue 안씀
    private Integer id; // Long --> bigint
}
