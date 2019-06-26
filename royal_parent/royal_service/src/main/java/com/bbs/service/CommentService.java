package com.bbs.service;

import com.bbs.domain.Comment;

import java.util.List;

public interface CommentService {
	/**
	 * 保存评论
	 * @param comment
	 */
	void save(Comment comment);

	/**
	 * 根据帖子id查询其评论
	 * @param articleId
	 * @return
	 */
	List<Comment> findCommentsByArticleId(Integer articleId);
}
