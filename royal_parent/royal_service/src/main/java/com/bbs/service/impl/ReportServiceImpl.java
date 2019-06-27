package com.bbs.service.impl;

import com.bbs.dao.ReportDao;
import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    /**
     * 举报功能
     * @param report
     */
    @Override
    public void saveReport(Report report) {
        reportDao.saveReport(report);
    }


    /**
     * 查询所有举报信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Report> findAll() throws Exception {
        return   reportDao.findAll();

    }

    /**
     * 删除举报信息
     * @return
     * @throws Exception
     */
    @Override
    public void deleteByReportIdId(Integer reportId) {
      reportDao.deleteByReportIdId(reportId);
    }
}
