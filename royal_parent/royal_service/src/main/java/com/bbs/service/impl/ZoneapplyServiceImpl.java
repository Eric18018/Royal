package com.bbs.service.impl;

import com.bbs.dao.ZoneDao;
import com.bbs.dao.ZoneapplyDao;
import com.bbs.domain.Zoneapply;
import com.bbs.service.ZoneapplyService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ZoneapplyServiceImpl implements ZoneapplyService {
    @Autowired
    private ZoneapplyDao zoneapplyDao;

    @Autowired
    private ZoneDao zoneDao;

    /**
     * 查询所有的版块
     */
    @Override
    public List<Zoneapply> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page, size);
        return zoneapplyDao.findAll();
    }

    /**
     * 版块的开通与关闭
     */
    @Override
    public void updateByApplyZoneId(Integer applyZoneId,Integer status) throws Exception {
        Zoneapply zoneapply = zoneapplyDao.findByApplyZoneId(applyZoneId);
        if (status == 0){
            status = -1;
            zoneDao.saveByZoneName(zoneapply.getZoneName());
        } else {
            status = 0;
            zoneDao.deleteByZoneName(zoneapply.getZoneName());
        }
        zoneapplyDao.updateByApplyZoneId(applyZoneId,status);
    }

    /**
     * 根据applyZoneId 删除版块申请信息
     */
    @Override
    public void deleteByApplyZoneId(Integer applyZoneId) throws Exception {
        zoneapplyDao.deleteByApplyZoneId(applyZoneId);
    }
}
