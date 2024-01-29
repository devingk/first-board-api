package com.devingk.firstboard.controller;

import com.devingk.firstboard.dto.request.ArticleCreationRequest;
import com.devingk.firstboard.dto.response.ArticleCreationResponse;
import com.devingk.firstboard.service.ArticleService;
import com.devingk.firstboard.test.data.TestArticle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

@WebMvcTest(controllers = ArticleController.class)
class ArticleControllerTest {

    @Autowired
    private ArticleController articleController;

    @MockBean
    private ArticleService articleService;

    @Test
    @DisplayName("글 생성")
    void createArticle() {

        //given
        ArticleCreationRequest request = TestArticle.articleCreationRequest();
        ArticleCreationResponse articleCreationResponse = ArticleCreationResponse.from(TestArticle.article(request));
        given(articleService.createArticle(request)).willReturn(articleCreationResponse);

        ResponseEntity<ArticleCreationResponse> expectedResponse = ResponseEntity.ok(articleCreationResponse);

        //when
        ResponseEntity<ArticleCreationResponse> response = articleController.createArticle(request);

        //then
        assertThat(response).isEqualTo(expectedResponse);
    }
}