package com.bbs.service.impl;

import com.bbs.dao.WordDao;
import com.bbs.domain.Word;
import com.bbs.service.WordService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WordServiceImpl implements WordService {
    @Autowired
    private WordDao wordDao;

    /**
     * 查询所有敏感词汇
     *
     * @param page 总页数
     * @param size 当前页数量
     * @return
     * @throws Exception
     */
    @Override
    public List<Word> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page, size);
        return wordDao.findAll();
    }

    /**
     * 敏感词汇开启关闭功能
     */
    @Override
    public void updateBywordId(Integer wordId, Integer status) throws Exception {
        if (status == 0) {
            status = 1;
        } else {
            status = 0;
        }
        wordDao.updateBywordId(wordId, status);
    }
}
