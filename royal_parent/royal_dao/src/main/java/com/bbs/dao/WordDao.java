package com.bbs.dao;

import com.bbs.domain.Word;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 敏感词汇表 持久层
 */
public interface WordDao {

    /**
     * 查询所有敏感词汇
     *
     * @return
     */
    @Select("SELECT * FROM bbs_word_table")
    List<Word> findAll() throws Exception;
}
