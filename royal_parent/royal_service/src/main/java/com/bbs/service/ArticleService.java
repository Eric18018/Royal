package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface ArticleService {
	void save(Article article);

	Article findByArticleId(Integer articleId);

	List<Article> findAllArticles();
}
