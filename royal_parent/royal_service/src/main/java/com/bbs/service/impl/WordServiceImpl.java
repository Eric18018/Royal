package com.bbs.service.impl;

import com.bbs.dao.WordDao;
import com.bbs.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WordServiceImpl implements WordService {
    @Autowired
    private WordDao wordDao;
}
