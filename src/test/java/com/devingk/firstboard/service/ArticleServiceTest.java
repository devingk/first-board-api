package com.devingk.firstboard.service;

import com.devingk.firstboard.dto.request.ArticleCreationRequest;
import com.devingk.firstboard.dto.response.ArticleCreationResponse;
import com.devingk.firstboard.entity.Article;
import com.devingk.firstboard.repository.ArticleRepository;
import com.devingk.firstboard.test.data.TestArticle;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService articleService;

    @Mock
    private ArticleRepository articleRepository;

    @Test
    @DisplayName("글 생성")
    void createArticle() {

        //given
        ArticleCreationRequest request = TestArticle.articleCreationRequest();

        Article article = TestArticle.article(request);
        BDDMockito.given(articleRepository.save(ArgumentMatchers.any())).willReturn(article);

        ArticleCreationResponse expectedResponse = ArticleCreationResponse.from(article);

        //when
        ArticleCreationResponse response = articleService.createArticle(request);

        //then
        Assertions.assertThat(response).isEqualTo(expectedResponse);
    }
}