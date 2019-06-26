package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface ArticleService {

	Article findByArticleId(Integer articleId);
    void save(Article article);
    //删帖功能
    void deleteByArticleId(Integer articleId) throws Exception;

	List<Article> findAllArticles();
}
