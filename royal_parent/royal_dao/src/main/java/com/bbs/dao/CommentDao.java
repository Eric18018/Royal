package com.bbs.dao;

import com.bbs.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 水帖表 持久层
 */
public interface CommentDao {

	/**
	 * 保存评论
	 * @param comment
	 */
	@Insert("insert into bbs_comment_table(commentContent,commentTime,commentUserName,articleId) values(#{commentContent},#{commentTime},#{commentUserName},#{articleId})")
	void save(Comment comment);

	/**
	 * 根据帖子id查询其评论
	 * @return
	 */
	@Select("select * from bbs_comment_table where articleId=#{articleId}")
	List<Comment> findCommentsByArticleId(Integer articleId);
}
