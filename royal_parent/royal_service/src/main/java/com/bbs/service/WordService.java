package com.bbs.service;

import com.bbs.domain.Word;

import java.util.List;

public interface WordService {

    /**
     * 查询所有敏感词汇
     *
     * @param page 总页数
     * @param size 当前页数量
     * @return
     * @throws Exception
     */
    List<Word> findAll(Integer page, Integer size) throws Exception;

    /**
     * 敏感词汇开启关闭功能
     */
    void updateBywordId(Integer wordId, Integer status) throws Exception;

    /**
     * 敏感词汇添加功能
     */
    void saveByWord(String word) throws Exception;
}
