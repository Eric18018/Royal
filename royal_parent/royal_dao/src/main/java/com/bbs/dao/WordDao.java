package com.bbs.dao;

import com.bbs.domain.Word;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    /**
     * 敏感词汇开启关闭功能
     */
    @Update("UPDATE bbs_word_table SET STATUS = #{status} WHERE wordid = #{wordId}")
    void updateBywordId(@Param("wordId") Integer wordId,@Param("status") Integer status);

    /**
     * 敏感词汇添加功能
     */
    @Insert("insert into bbs_word_table (word) values (#{word})")
    void saveByWord(String word);
}
