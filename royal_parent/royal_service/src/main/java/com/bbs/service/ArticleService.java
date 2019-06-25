package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface ArticleService {
	void save(Article article);

	Article findByArticleId(Integer articleId);

	/**
	 * 查询所有帖子
	 * @return
	 * @throws Exception
	 */
    List<Article> findAll()throws Exception;

}
