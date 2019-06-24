package com.bbs.service.impl;

import com.bbs.dao.ZoneapplyDao;
import com.bbs.service.ZoneapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ZoneapplyServiceImpl implements ZoneapplyService {
    @Autowired
    private ZoneapplyDao zoneapplyDao;
}
