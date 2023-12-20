package com.devingk.firstboard.test.data;

import com.devingk.firstboard.dto.request.ArticleCreationRequest;
import com.devingk.firstboard.entity.Article;
import com.devingk.firstboard.test.util.TestTimeUtil;

public class TestArticle {

    public static ArticleCreationRequest articleCreationRequest() {
        return ArticleCreationRequest.builder()
                .title("테스트 아티클 제목")
                .author("테스트 아티클 작성자")
                .contents("테스트 아티클 내용")
                .build();
    }

    public static Article article(ArticleCreationRequest request) {
        Article article = Article.builder()
                .id(1L)
                .title(request.title())
                .author(request.author())
                .contents(request.contents())
                .build();

        TestTimeUtil.setDateTime(article);

        return article;
    }
}
