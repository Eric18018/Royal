package com.bbs.service;

import com.bbs.domain.Zoneapply;

import java.util.List;

public interface ZoneapplyService {

    /**
     * 查询所有的版块
     */
    List<Zoneapply> findAll(Integer page, Integer size) throws Exception;

    /**
     * 版块的开通与关闭
     */
    void updateByApplyZoneId(Integer applyZoneId,Integer status) throws Exception;

    /**
     * 根据applyZoneId 删除版块申请信息
     */
    void deleteByApplyZoneId(Integer applyZoneId) throws Exception;
}
