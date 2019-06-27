package com.bbs.dao;

import com.bbs.domain.Report;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * 举报表 持久层
 */
public interface ReportDao {
    /**
     * 举报功能
     * @param report
     */
    @Insert("insert into bbs_report_table (reportContent,reportTime,reportUserName,reportStatus,articleId) values (#{reportContent},#{reportTime},#{reportUserName},#{reportStatus},#{articleId})")
    void saveReport(Report report);
}
