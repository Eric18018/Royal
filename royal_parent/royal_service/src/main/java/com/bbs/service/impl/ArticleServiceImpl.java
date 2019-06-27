package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.dao.UserDao;
import com.bbs.domain.Article;
import com.bbs.domain.User;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        article.setIsReport(0);
        articleDao.save(article);
    }


    //删帖功能
    @Override
    public void deleteByArticleId(Integer articleId) throws Exception {
        articleDao.deleteByArticleId(articleId);
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

	/**
	 * 查询所有article的方法
	 * @return
	 */
	@Override
	public List<Article> findAllArticles() {
		return articleDao.findAllArticles();
	}

	/**
	 * 根据板块id查找对应文章
	 * @param zoneId
	 * @return
	 */
	@Override
	public List<Article> findArticlesByZoneId(Integer zoneId) {
		return articleDao.findArticlesByZoneId(zoneId);
	}

	/**
	 * 查询帖子总数
	 * @return
	 */
	@Override
	public Integer countTotalArticles() {
		return articleDao.countTotalArticles();
	}

	/**
	 * 查询今日帖子数
	 * @return
	 */
	@Override
	public Integer findTodayArticles() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		return articleDao.findTodayArticles(today);
	}

	/**
	 * 查询所有帖子
	 *
	 * @param page 总页数
	 * @param size 当前页数量
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Article> findAll(Integer page, Integer size) throws Exception {
		PageHelper.startPage(page, size);
		return articleDao.findAll();
	}

	/**
	 * 置顶功能的开启和关闭
	 * @param articleId  贴子id
	 * @param isTop      置顶状态
	 * @return
	 * @throws Exception
	 */
	@Override
	public void updateByArticleId(Integer articleId, Integer isTop) throws Exception {
		if (isTop == 0){
			isTop =1;
		}else {
			isTop = 0;
		}
		articleDao.updateByArticleId(articleId,isTop);
	}

	/**
	 * 关键字查询功能
	 * @param msg
	 * @return
	 */
	@Override
	public List<Article> findByLike(String msg) {
		return articleDao.findByLike(msg);
	}



	/**
	 * 帖子根据标题和创帖人查询
	 * @param name  发帖人
	 * @param title  标题
	 * @return
	 *
	 */
	@Override
	public List<Article> findByUsernameAndTitle(String title, String name,Integer page, Integer size) {
		PageHelper.startPage(page,size);
		return articleDao.findByUsernameAndTitle(title,name);
	}
}
