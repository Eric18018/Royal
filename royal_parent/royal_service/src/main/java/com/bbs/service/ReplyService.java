package com.bbs.service;

import com.bbs.domain.Reply;

import java.util.List;
import java.util.Map;

public interface ReplyService {

	/**
	 * 保存回复的方法
	 * @param reply
	 */
	void save(Reply reply);

	/**
	 * 根据帖子id查询其所有评论的回复
	 * @param articleId
	 * @return
	 */
	Map<Integer,List<Reply>> findRepliesByArticle(Integer articleId);

	/**
	 * 统计帖子下回复总数
	 * @param articleId
	 * @return
	 */
	Integer countCommentsAndReplies(Integer articleId);
}
