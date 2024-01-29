package com.devingk.firstboard.controller;

import com.devingk.firstboard.dto.request.ArticleCreationRequest;
import com.devingk.firstboard.dto.request.ArticleListRequest;
import com.devingk.firstboard.dto.response.ArticleCreationResponse;
import com.devingk.firstboard.dto.response.ArticleListResponse;
import com.devingk.firstboard.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleCreationResponse> createArticle(
            @Validated @RequestBody ArticleCreationRequest request) {

        return ResponseEntity.ok(articleService.createArticle(request));
    }

    @GetMapping
    public ResponseEntity<ArticleListResponse> listArticles(
            @Validated @RequestBody ArticleListRequest request) {

        return ResponseEntity.ok(articleService.listArticles(request));
    }
}

