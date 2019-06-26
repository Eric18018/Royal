package com.bbs.dao;

import com.bbs.domain.Zone;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

	/**
	 * 根据zoneName增加版块
	 */
	@Insert("INSERT INTO bbs_zone_table (zonename,isDef) VALUES (#{zoneName},2)")
	void saveByZoneName(String zoneName);


	/**
	 * 根据zoneName删除版块
	 */
	@Delete("DELETE FROM bbs_zone_table WHERE zoneName = #{zoneName}")
	void deleteByZoneName(String zoneName);
}
