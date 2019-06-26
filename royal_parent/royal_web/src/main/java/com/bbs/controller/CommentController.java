package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.domain.Comment;
import com.bbs.service.ArticleService;
import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    ArticleService articleService;


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
        ModelAndView mv = new ModelAndView();
        mv.addObject("article", article);
        mv.addObject("comments", comments);
        mv.setViewName("getArticle");
        return mv;
    }

}
