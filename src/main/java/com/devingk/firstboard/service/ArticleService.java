package com.devingk.firstboard.service;

import com.devingk.firstboard.dto.request.ArticleCreationRequest;
import com.devingk.firstboard.dto.response.ArticleCreationResponse;
import com.devingk.firstboard.entity.Article;
import com.devingk.firstboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleCreationResponse createArticle(ArticleCreationRequest request) {

        Article article = articleRepository.save(Article.from(request));

        return ArticleCreationResponse.from(article);
    }
}
