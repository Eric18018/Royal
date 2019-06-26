package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.domain.Zone;
import com.bbs.service.ArticleService;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    ZoneService zoneService;

    /**
     * 查询所有首页元素内容的方法
     */
    @RequestMapping("/findIndexContent.do")
    public ModelAndView findIndexContent() {
        ModelAndView mv = new ModelAndView();
        List<Article> articles = articleService.findAllArticles();
        List<Zone> zones = zoneService.findAllZones();
        mv.addObject("articles", articles);
        mv.addObject("zones", zones);
        mv.setViewName("main");
        return mv;
    }

    /**
     * 保存发帖
     * @param article
     * @return
     */
    @RequestMapping("/save.do")
    public String save(Article article) {
        articleService.save(article);
        return "redirect:findByArticleId.do?articleId=" + article.getArticleId();
    }

    /**
     * 根据帖子id查找帖子信息
     *
     * @return
     */
    @RequestMapping("/findByArticleId.do")
    public ModelAndView findByArticleId(Integer articleId) {
        ModelAndView mv = new ModelAndView();
		Article article = articleService.findByArticleId(articleId);
		mv.addObject("article", article);
		mv.setViewName("getArticle");
        return mv;
    }


}