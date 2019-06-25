package com.bbs.dao;

import com.bbs.domain.Zone;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 版块表
 */


public interface ZoneDao {
	/**
	 * 查询所有版块的方法
	 */
	@Select("select * from bbs_zone_table")
	List<Zone> findAllZones();
}
