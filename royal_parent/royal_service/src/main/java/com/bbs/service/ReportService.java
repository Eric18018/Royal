package com.bbs.service;

import com.bbs.domain.Article;
import com.bbs.domain.Report;

import java.util.List;

import com.bbs.domain.Report;

public interface ReportService {
    /**
     * 举报功能
     * @param report
     */
    void saveReport(Report report);



    /**
     * 查询所有举报信息
     * @return
     * @throws Exception
     */
    List<Report> findAll()throws Exception;

    /**
     * 删除举报信息
     * @return
     * @throws Exception
     */
    void deleteByReportIdId(Integer reportId);
}
