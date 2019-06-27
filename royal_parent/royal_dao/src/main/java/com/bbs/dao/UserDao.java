package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表 持久层
 */
@Repository("userDao")
public interface UserDao {

    /**
     * 查询所有用户数据
     *
     * @return
     */
    @Select("select * from bbs_user_table")
    public List<User> findAll();

    /**
     * 保存用户注册信息的方法
     *
     * @param user
     * @return
     */
    @Insert("insert into bbs_user_table(userName,userPass,email,picUrl,role,lastLoginTime,loginStatus,talkStatus,isupdating,updateStatus) values(#{userName},#{userPass},#{email},#{picUrl},#{role},#{lastLoginTime},#{loginStatus},#{talkStatus},#{isupdating},#{updateStatus})")
    void saveRegister(User user);

    /**
     * 查询数据库是否有该用户名的方法
     *
     * @param username
     * @return
     */
    @Select("select *from bbs_user_table where userName = #{userName}")
    User findByUsername(String username);

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

    /**
     * 根据用户名和密码查询user对象的方法
     *
     * @param userName
     * @param userPass
     * @return
     */
    @Select("select * from bbs_user_table where userName=#{userName} and userPass=#{userPass}")
    User findByNameAndPass(@Param("userName") String userName, @Param("userPass") String userPass);

    /**
     * 用户升级功能
     *
     * @param isupdating   是否申请升级
     * @param updateStatus 申请审核状态
     * @param role         用户级别
     * @param userId       用户id
     */
    @Update("update bbs_user_table set isupdating = #{isupdating},updateStatus = #{updateStatus},role = #{role} where userId = #{userId}")
    void updateByUserId(@Param("isupdating") Integer isupdating, @Param("updateStatus") Integer updateStatus,
                        @Param("role") Integer role, @Param("userId") Integer userId);

    /**
     * 禁言功能
     * @param userId        用户id
     * @param talkStatus    禁言状态
     * @return
     * @throws Exception
     */
    @Update("update bbs_user_table set talkStatus = #{talkStatus} where userId = #{userId}")
    void stopByUserId(@Param("userId") Integer userId, @Param("talkStatus") Integer talkStatus);
}
