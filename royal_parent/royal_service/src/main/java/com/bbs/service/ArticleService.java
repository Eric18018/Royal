package com.bbs.service;

import com.bbs.domain.Article;
import com.bbs.domain.User;

import java.util.List;

public interface ArticleService {

	Article findByArticleId(Integer articleId);

    void save(Article article);

	List<Article> findAllArticles();

	List<Article> findArticlesByZoneId(Integer zoneId);

	Integer countTotalArticles();

	Integer findTodayArticles();

	/**
	 * 删帖功能
	 */
	void deleteByArticleId(Integer articleId) throws Exception;

	/**
	 * 查询所有帖子
	 *
	 * @param page 总页数
	 * @param size 当前页数量
	 * @return
	 * @throws Exception
	 */
	List<Article> findAll(Integer page, Integer size) throws Exception;

	/**
	 * 置顶功能的开启和关闭
	 * @param articleId  贴子id
	 * @param isTop      置顶状态
	 * @return
	 * @throws Exception
	 */
	void updateByArticleId(Integer articleId, Integer isTop) throws Exception;

	/**
	 * 关键字查询功能
	 * @param msg
	 * @return
	 */
    List<Article> findByLike(String msg);


	/**
	 * 根据发帖人和标题查询
	 * @param name  贴子id
	 * @param title      置顶状态
	 * @return
	 * @throws Exception
	 */

    List<Article> findByUsernameAndTitle(String title, String name, Integer page, Integer size)throws Exception;


}
