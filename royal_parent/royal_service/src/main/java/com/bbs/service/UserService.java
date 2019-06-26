package com.bbs.service;

import com.bbs.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void updateEmail(User user) throws Exception;

    void updatePassWord(String passWord, String newPwd) throws Exception;

    /**
     * 保存用户注册信息的方法
     * @param user
     * @return
     */
    boolean saveRegister(User user);

    /**
     * 查询数据库是否有该用户名的方法
     * @param username
     * @return
     */
    User findByUsername(String username);

	User findByNameAndPass(String userName, String userPass);
}
