package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.domain.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")

@Slf4j
public class ArticleController {

    // repository 추가
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value = "/list")
    public String getAll(Model model) {
        List<Article> articleList = (List<Article>) articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        return "list";
    }

    @GetMapping(value = "")  // http://localhost:8080/articles 호출 시 자동으로 http://localhost:8080/articles/list 로 실행
    public String index() {
        return "redirect:/articles/list";
    }

    @GetMapping(value = "/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @GetMapping(value = "/{id}")
    public String selectSingle(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);
        if (!optArticle.isEmpty()) {
            model.addAttribute("article", optArticle.get());
            return "show";
        } else {
            return "error";
        }
    }

    @PostMapping(value = "/posts")
    public String createArticle(ArticleDto form) {
        log.info(form.toString()); // 서버에서 일어나는 일을 기록
        Article article = form.toEntity();  // 1. Dto를 Entity로 변환
        Article saved = articleRepository.save(article);    // 2. Repository에게 Entity를 DB에 저장하게 한다.
        log.info("generatedId:{}", saved.getId());
        return String.format("redirect:/articles/%d", saved.getId());  // 리다이렉트 코드, 메서드 작동이 끝나면 /articles/{id} 페이지를 반환한다.
    }
}
