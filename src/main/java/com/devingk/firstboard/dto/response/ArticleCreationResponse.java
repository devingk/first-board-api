package com.devingk.firstboard.dto.response;

import com.devingk.firstboard.entity.Article;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ArticleCreationResponse(
        String title, String author, String contents,
        LocalDateTime createdAt, LocalDateTime modifiedAt) {

    public static ArticleCreationResponse from(Article article) {
        return ArticleCreationResponse.builder()
                .title(article.getTitle())
                .author(article.getAuthor())
                .contents(article.getContents())
                .createdAt(article.getCreatedAt())
                .modifiedAt(article.getModifiedAt())
                .build();
    }
}
