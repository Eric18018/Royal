package com.bbs;

import java.io.Serializable;

public class Word implements Serializable{
    private Integer wordId;
    private String word;//敏感词
    private Integer status; //是否启用 (0代表启用，1代表未启用)
    private String statusStr;

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        //是否启用 (0代表启用，1代表未启用)
        if (status !=null){
            if (status ==0){
                statusStr = "启用";
            }else if (status ==1){
                statusStr = "未启用";
            }
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }
}
