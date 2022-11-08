package com.mustache.bbs.domain.repository;

import com.mustache.bbs.domain.entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
    // < 관리대상엔티티, 대표값의 타입( Aticle의 대표값 id의 타입은 long)>
    @Override
    List<Article> findAll(); // 메소드 오버라이딩으로 List 타입으로 바꿔준다.
}
