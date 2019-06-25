package com.bbs.dao;

import com.bbs.domain.Article;

/**
 * 帖子表 持久层
 */
public interface ArticleDao {
	/**
	 * 添加文章的方法
	 * @param article
	 */
	void save(Article article);
}
