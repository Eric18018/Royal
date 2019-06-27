package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.domain.User;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
     *
     * @param page 总页数
     * @param size 当前页数量
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Article> articles = articleService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(articles);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("articleId-list");
        return mv;
    }

    //删帖功能
    @RequestMapping("/deleteByArticleId.do")
    public String deleteByArticleId (Integer articleId) throws Exception{
        articleService.deleteByArticleId(articleId);
        return "redirect:findAll.do";
    }

    /**
     * 置顶功能的开启和关闭
     * @param articleId  贴子id
     * @param isTop      置顶状态
     * @return
     * @throws Exception
     */
    @RequestMapping("updateByArticleId.do")
    public String updateByArticleId (@RequestParam(name = "articleId", required = true) Integer articleId,
                                     @RequestParam(name = "isTop", required = true) Integer isTop) throws Exception{
        articleService.updateByArticleId(articleId,isTop);
        return "redirect:findAll.do";
    }


    /**
     * 帖子根据标题和创帖人查询
     * @param  name 发帖人
     * @param  title    标题
     * @return
     * @throws Exception
     */
    @RequestMapping("/findByUsernameAndTitle.do")
    public ModelAndView findByUsernameAndTitle(@RequestParam(name = "title",required = true)String title,
                                            @RequestParam(name = "name",required = true)String name,
                                            @RequestParam(name = "Page",required = true,defaultValue = "1")Integer page,
                                            @RequestParam(name = "size",required = true,defaultValue = "5")Integer size )throws Exception{


         if (name!=""){
          name='%'+name+'%';
          title=null;
          }
        if (title!="" && title!=null){
            title='%'+title+'%';
            name=null;
        }

        List<Article> list = articleService.findByUsernameAndTitle(title,name,page,size);
        ModelAndView mv = new ModelAndView();
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        System.out.println(pageInfo);
        mv.setViewName("articleId-list");
        return mv;
    }
}
