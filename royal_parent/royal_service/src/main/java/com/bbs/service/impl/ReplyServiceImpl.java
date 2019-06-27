package com.bbs.service.impl;

import com.bbs.dao.CommentDao;
import com.bbs.dao.ReplyDao;
import com.bbs.domain.Comment;
import com.bbs.domain.Reply;
import com.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyDao replyDao;

    @Autowired
    private CommentDao commentDao;

    /**
     * 保存回复的方法
     * @param reply
     */
    @Override
    public void save(Reply reply) {
        reply.setReplyTime(new Date());
        replyDao.save(reply);
    }

    /**
     * 根据帖子id查询其所有评论的回复
     * @param articleId
     * @return
     */
    @Override
    public Map<Integer, List<Reply>> findRepliesByArticle(Integer articleId) {
		Map<Integer, List<Reply>> map = new HashMap<>();
        List<Comment> comments = commentDao.findCommentsByArticleId(articleId);
        for (Comment comment : comments) {
            List<Reply> replies = replyDao.findRepliesByCommentId(comment.getCommentId());
            map.put(comment.getCommentId(), replies);
        }
        return map;
    }

    /**
     * 统计帖子下回复总数
     * @param articleId
     * @return
     */
    @Override
    public Integer countCommentsAndReplies(Integer articleId) {
        Integer countComments = commentDao.countCommentsByArticleId(articleId);
        Integer countReplies = 0;
        List<Comment> comments = commentDao.findCommentsByArticleId(articleId);
        for (Comment comment : comments) {
            Integer countReply = replyDao.countRepliesByCommentId(comment.getCommentId());
            countReplies += countReply;
        }
        return countComments + countReplies;
    }
}
