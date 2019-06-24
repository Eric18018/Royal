package com.bbs.dao;

import com.bbs.domain.Article;

/**
 * 帖子表 持久层
 */
public interface ArticleDao {
	void save(Article article);
}
