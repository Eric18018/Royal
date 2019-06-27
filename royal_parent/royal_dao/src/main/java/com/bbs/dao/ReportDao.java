package com.bbs.dao;

import com.bbs.domain.Report;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    /**
     * 查询所有举报信息
     * @return
     * @throws Exception
     */
    @Select("select * from bbs_report_table")
    List<Report> findAll()throws Exception;



    /**
     * 删除举报信息
     * @return
     * @throws Exception
     */
    @Delete("delete from bbs_report_table where reportId=#{reportId}")
    void deleteByReportIdId(Integer reportId);
}
