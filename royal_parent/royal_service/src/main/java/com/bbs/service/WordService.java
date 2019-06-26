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
}
