package com.bbs.controller;

import com.bbs.domain.Article;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbs.service.ArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 查询所有帖子
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Article> list = articleService.findAllArticles();
        mv.addObject("articleList",list);
        mv.setViewName("articleId-list");
        return mv;
    }

    //删帖功能
    @RequestMapping("/deleteByArticleId.do")
    public String deleteByArticleId (@RequestParam(name = "articleId" ,required = true) Integer articleId) throws Exception{
        articleService.deleteByArticleId(articleId);
        return "redirect:findAll.do";
    }
}
