package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 删除举报信息
     * @return
     * @throws Exception
     */

    @RequestMapping("/deleteByReportId.do")
    public String deleteByArticleId (Integer reportId) throws Exception{
        reportService.deleteByReportIdId(reportId);
        return "redirect:findAll.do";
    }

    /**
     * 查询所有举报信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        List<Report> list = reportService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("report_list",list);
        mv.setViewName("report-list");
        return mv;
    }


    /**
     * 帖子根据标题和创帖人查询
     * @param  name 发帖人
     * @param  title    标题
     * @return
     * @throws Exception
     */
    @RequestMapping("/findByUsernameAndTitle.do")
    public ModelAndView findNameAndtitle(@RequestParam(name = "name",required = true)String name, @RequestParam(name = "title",required = true)String title)throws Exception{
       // List<Article>list = reportService.findByUsernameAndTitle("%"+name+"%","%"+title+"%");
        ModelAndView mv = new ModelAndView();
       // mv.addObject("pageInfo.list",list);
        mv.setViewName("articleId-list");
        return mv;
    }

}
