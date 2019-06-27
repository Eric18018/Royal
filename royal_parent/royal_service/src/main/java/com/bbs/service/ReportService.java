package com.bbs.service;

import com.bbs.domain.Report;

public interface ReportService {
    /**
     * 举报功能
     * @param report
     */
    void saveReport(Report report);
}
