package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    /**
     * 保存发帖
     * @param article
     */
    @Override
    public void save(Article article) {
        article.setSendTime(new Date());
        article.setIsTop(0);
        article.setReplyCount(0);
        article.setUpvoteCount(0);
        article.setBrowseCount(0);
        article.setBrowseCount(0);
        article.setZoneId(1);
        article.setIsReport(0);
        //登录功能未完成，暂时手动输入用户名
        article.setSenderName("Tom");
        articleDao.save(article);
    }

	/**
	 * 根据articleId查看帖子
	 * @param articleId
	 * @return
	 */
	@Override
	public Article findByArticleId(Integer articleId) {
		return articleDao.findByArticleId(articleId);
	}
}
