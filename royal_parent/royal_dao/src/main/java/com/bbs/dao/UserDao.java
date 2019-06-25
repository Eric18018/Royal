package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * 用户表 持久层
 */
@Repository("userDao")
public interface UserDao {

    @Select("select * from bbs_user_table")
    public List<User> findAll();

    @Select("select * from bbs_user_table where userName = #{username}")
    public List<User> findByUsername(String username);
}
