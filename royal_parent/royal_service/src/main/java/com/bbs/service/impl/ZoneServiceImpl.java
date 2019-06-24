package com.bbs.service.impl;

import com.bbs.dao.ZoneDao;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ZoneServiceImpl implements ZoneService {
    @Autowired
    private ZoneDao zoneDao;
}
