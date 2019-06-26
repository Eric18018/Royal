package com.bbs.dao;

import com.bbs.domain.Zoneapply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 版块申请表 持久层
 */
public interface ZoneapplyDao {

    /**
     * 查询所有的版块
     */
    @Select("select * from bbs_zoneapply_table")
    List<Zoneapply> findAll() throws Exception;

    /**
     * 根据applyZoneId 查询版块详情
     */
    @Select("select * from bbs_zoneapply_table where applyZoneId = #{applyZoneId}")
    Zoneapply findByApplyZoneId (Integer applyZoneId) throws Exception;

    /**
     * 版块的开通与关闭
     */
    @Update("UPDATE bbs_zoneapply_table SET STATUS = #{status} WHERE applyZoneId = #{applyZoneId}")
    void updateByApplyZoneId(@Param("applyZoneId") Integer applyZoneId,@Param("status") Integer status);

    /**
     * 根据applyZoneId 删除版块申请信息
     */
    @Delete("delete from bbs_zoneapply_table where applyZoneId=#{applyZoneId}")
    void deleteByApplyZoneId(Integer applyZoneId);
}
