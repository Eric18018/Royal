package com.bbs;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable{

    private Integer reportId;
    private String reportContent;//举报内容
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date reportTime;//举报时间
    private String reportTimeStr;
    private String reportUserName;//举报人
    private Integer reportStatus;//举报状态
    private Integer articleId;//文章ID

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportUserName() {
        return reportUserName;
    }

    public void setReportUserName(String reportUserName) {
        this.reportUserName = reportUserName;
    }

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getReportTimeStr() {
        if(reportTime!=null){
            reportTimeStr= DateUtils.date2String(reportTime,"yyyy-MM-dd HH:mm:ss");
        }
        return reportTimeStr;
    }

    public void setReportTimeStr(String reportTimeStr) {
        this.reportTimeStr = reportTimeStr;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", reportContent='" + reportContent + '\'' +
                ", reportTime=" + reportTime +
                ", reportTimeStr='" + reportTimeStr + '\'' +
                ", reportUserName='" + reportUserName + '\'' +
                ", reportStatus=" + reportStatus +
                ", articleId=" + articleId +
                '}';
    }
}
