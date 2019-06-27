package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.domain.Comment;
import com.bbs.domain.Reply;
import com.bbs.service.ArticleService;
import com.bbs.service.CommentService;
import com.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    ArticleService articleService;

    @Autowired
    ReplyService replyService;


    /**
     * 保存评论
     * @param comment
     * @return
     */
    @RequestMapping("/save.do")

    public String save(Comment comment) {
        commentService.save(comment);
        return "redirect:findByArticleId.do?articleId=" + comment.getArticleId();
    }

    /**
     * 根据帖子id查找帖子信息
     *
     * @return
     */
    @RequestMapping("/findByArticleId.do")
    public ModelAndView findByArticleId(Integer articleId) {
        Article article = articleService.findByArticleId(articleId);
        List<Comment> comments = commentService.findCommentsByArticleId(articleId);
        Map<Integer, List<Reply>> replies = replyService.findRepliesByArticle(articleId);
		//查询帖子的回复数
		Integer countCommentsAndReplies = replyService.countCommentsAndReplies(articleId);
        articleService.updateArticleReplyCount(articleId,countCommentsAndReplies);
        ModelAndView mv = new ModelAndView();
		mv.addObject("countCommentsAndReplies", countCommentsAndReplies);
        mv.addObject("article", article);
        mv.addObject("comments", comments);
        mv.addObject("replies", replies);
        mv.setViewName("getArticle");
        return mv;
    }

}
