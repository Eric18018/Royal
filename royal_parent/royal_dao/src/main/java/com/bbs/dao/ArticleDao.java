package com.bbs.dao;
import com.bbs.domain.User;
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
	 * @return
	 */
	@Select("select * from bbs_article_table")
	List<Article> findAll();

	/**
	 * 置顶功能的开启和关闭
	 * @param articleId  贴子id
	 * @param isTop      置顶状态
	 * @return
	 * @throws Exception
	 */
	@Update("update bbs_article_table set isTop = #{isTop} where articleId = #{articleId}")
	void updateByArticleId(@Param("articleId") Integer articleId,@Param("isTop") Integer isTop);

	/**
	 * 更新帖子回复数的方法
	 * @param replyCount
	 */
	@Update("update bbs_article_table set replyCount=#{replyCount} where articleId = #{articleId}")
	void updateArticleReplyCount(@Param("articleId") Integer articleId, @Param("replyCount")Integer replyCount);


	/**
	 * 关键字查询功能
	 * @param msg
	 * @param
	 * @param
	 * @return
	 */
	@Select("SELECT * FROM bbs_article_table WHERE title LIKE #{msg}")
    List<Article> findByLike(String msg);





	/**
	 * 后台查询根据创帖人或标题查询，在创帖人和标题都为空的情况下调用此方法
	 *
	 */

	@Select("select * from bbs_article_table")
	List<Article> findAllArticle(@Param("name") String name, @Param("title") String title,@Param("page") Integer page,@Param("size") Integer size);




	/**
	 * 后台帖子根据标题和创帖人查询
	 * @param name  创帖人
	 * @param title  标题
	 * @return
	 *
	 */
	@Select("select * from bbs_article_table where title like #{title} or senderName like #{name} ")
	List<Article> findByUsernameAndTitle(@Param("title") String title, @Param("name") String name);
}
