package com.bbs.service.impl;

import com.bbs.dao.UpvoteDao;
import com.bbs.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UpvoteServiceImpl implements UpvoteService {
    @Autowired
    private UpvoteDao upvoteDao;
}
