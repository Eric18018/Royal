package com.bbs.service;

import com.bbs.domain.User;
import jdk.nashorn.internal.ir.IfNode;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
    /**
     * 查询所有用户信息
     *
     * @param page 当前页码
     * @param size 每页数量
     * @return
     */
    List<User> findAll(Integer page, Integer size) throws Exception;

    void updateEmail(User user) throws Exception;

    void updatePassWord(String passWord, String newPwd) throws Exception;

    /**
     * 保存用户注册信息的方法
     *
     * @param user
     * @return
     */
    boolean saveRegister(User user);

    /**
     * 查询数据库是否有该用户名的方法
     *
     * @param username
     * @return
     */
//    User findByUsername(String username);


    /**
     * 查询有用户名和角色
     * @param name,role
     * @return
     */
    List<User> findUsernameAndRole(String name, String role,Integer page,Integer size);



    /**
     * 查询有用户名和角色
     * @param userName,role
     * @return
     */
//    List<User> findUsernameAndRole(String name, Integer role);

    User findByNameAndPass(String userName, String userPass);

    /**
     * 用户升级功能
     * @param userId  用户id
     * @param role    用户级别
     * @return
     * @throws Exception
     */
    void updateByUserId(Integer userId, Integer role) throws Exception;

    /**
     * 禁言功能
     * @param userId        用户id
     * @param talkStatus    禁言状态
     * @return
     * @throws Exception
     */
    void stopByUserId(Integer userId, Integer talkStatus) throws Exception;




	//User findByNameAndPass(String userName, String userPass);
}
