package com.bbs.controller;

import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 举报功能
     * @param report
     * @return
     */
    @RequestMapping("/setReport.do")
    public String setReport(Report report,Integer articleId){

        Date date = new Date();
        report.setReportTime(date);
        report.setReportStatus(1);
        reportService.saveReport(report);
        return "redirect:/comment/findByArticleId.do?articleId="+articleId;
    }
}
