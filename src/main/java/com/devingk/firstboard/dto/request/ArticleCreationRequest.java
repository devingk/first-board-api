package com.devingk.firstboard.dto.request;

import lombok.Builder;

@Builder
public record ArticleCreationRequest(String title, String author, String contents) {
}
