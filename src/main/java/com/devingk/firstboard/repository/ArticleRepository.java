package com.devingk.firstboard.repository;

import com.devingk.firstboard.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
