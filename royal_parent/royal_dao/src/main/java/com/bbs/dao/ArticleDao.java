package com.bbs.dao;
import org.apache.ibatis.annotations.*;
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

	/**
	 * 查询总帖子数的方法
	 * @return
	 */
	@Select("select count(*) from bbs_article_table")
	Integer countTotalArticles();

	/**
	 * 查询今日帖子数的方法
	 * @param today
	 * @return
	 */
	@Select("select count(*) from bbs_article_table where sendTime like '%${value}%'")
	Integer findTodayArticles(String today);

	/**
	 * 查询所有帖子
	 *
	 * @param page 总页数
	 * @param size 当前页数量
	 * @return
	 * @throws Exception
	 */
	@Select("select * from bbs_article_table")
	List<Article> findAll(Integer page, Integer size);

	/**
	 * 置顶功能的开启和关闭
	 * @param articleId  贴子id
	 * @param isTop      置顶状态
	 * @return
	 * @throws Exception
	 */
	@Update("update bbs_article_table set isTop = #{isTop} where articleId = #{articleId}")
	void updateByArticleId(@Param("articleId") Integer articleId,@Param("isTop") Integer isTop);
}
