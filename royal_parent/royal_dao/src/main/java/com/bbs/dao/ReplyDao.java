package com.bbs.dao;

import com.bbs.domain.Comment;
import com.bbs.domain.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 回复表 持久层
 */
public interface ReplyDao {

	/**
	 * 保存回复的方法
	 * @param reply
	 */
	@Insert("insert into bbs_reply_table(replyContent,replyTime,replyUserName,commentId) values(#{replyContent},#{replyTime},#{replyUserName},#{commentId})")
	void save(Reply reply);

	/**
	 * 根据评论id查询其所有回复的方法
	 * @param commentId
	 * @return
	 */
	@Select("select * from bbs_reply_table where commentId=#{commentId}")
	List<Reply> findRepliesByCommentId(Integer commentId);

	/**
	 * 根据评论id查询回复数量
	 * @param commentId
	 * @return
	 */
	@Select("select count(*) from bbs_reply_table where commentId=#{commentId}")
	Integer countRepliesByCommentId(Integer commentId);
}
