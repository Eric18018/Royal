package com.bbs.dao;

import org.apache.ibatis.annotations.Delete;
import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 帖子表 持久层
 */
public interface ArticleDao {
	/**
	 * 添加文章的方法
	 * @param article
	 */
	@Insert("insert into bbs_article_table(title,content,sendTime,senderName,isTop,replyCount,upvoteCount,browseCount,zoneId,isReport) values(#{title},#{content},#{sendTime},#{senderName},#{isTop},#{replyCount},#{upvoteCount},#{browseCount},#{zoneId},#{isReport})")
	@Options(useGeneratedKeys=true, keyProperty="articleId", keyColumn="articleId")
	void save(Article article);

	/**
	 * 根据articleId查询帖子
	 * @param articleId
	 * @return
	 */
	@Select("select * from bbs_article_table where articleId=#{articleId}")
	Article findByArticleId(Integer articleId);

    //根据articleId删帖
    @Delete("DELETE FROM bbs_article_table WHERE articleId = #{articleId}")
    void deleteByArticleId(Integer articleId);

	/**
	 * 查询所有帖子的方法
	 * @return
	 */
	@Select("select * from bbs_article_table")
	List<Article> findAllArticles();

	/**
	 * 查询板块id查询对应帖子
	 * @return
	 */
	@Select("select * from bbs_article_table where zoneId=#{zoneId}")
	List<Article> findArticlesByZoneId(Integer zoneId);

}
