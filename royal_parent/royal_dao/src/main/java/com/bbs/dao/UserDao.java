package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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


    /**
     * 更改邮箱的方法
     *
     * @param user
     */
    @Update("update bbs_user_table SET email =#{email}, picUrl =#{picUrl} where userName =#{userName}")
    void updateEmail(User user) throws Exception;

    //更改密码
    @Update("update bbs_user_table set userPass = #{passWord} where userId=#{userId}")
    void upDatePassWord(String passWord);
}
