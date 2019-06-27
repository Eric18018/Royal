package com.bbs.service.impl;

import com.bbs.dao.CommentDao;
import com.bbs.domain.Comment;
import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    /**
     * 保存评论
     * @param comment
     */
    @Override
    public void save(Comment comment) {
        comment.setCommentTime(new Date());
        commentDao.save(comment);
    }

    /**
     * 根据帖子id查询其评论
     * @param articleId
     * @return
     */
    @Override
    public List<Comment> findCommentsByArticleId(Integer articleId) {
        return commentDao.findCommentsByArticleId(articleId);
    }

    /**
     * 根据评论id查询帖子id的方法
     * @param commentId
     * @return
     */
    @Override
    public Integer findArticleIdByCommentId(Integer commentId) {
        return commentDao.findArticleIdByCommentId(commentId);
    }

}
