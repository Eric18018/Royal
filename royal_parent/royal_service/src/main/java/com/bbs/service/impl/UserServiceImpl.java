package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 保存用户注册信息的方法
     * @param user
     * @return
     */
    @Override
    public boolean saveRegister(User user) {
        User u = userDao.findByUsername(user.getUserName());
        if (u!=null){
            return false;
        }
        userDao.saveRegister(user);
        return true;
    }

    /**
     * 查询数据库是否有该用户名的方法
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {

        return  userDao.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 更改邮箱地址
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public void updateEmail(User user) throws Exception {
        userDao.updateEmail(user);


    }

    //更改密码
    @Override
    public void updatePassWord(String oldPassword,String newPassword) throws Exception {
        //对参数进行非空验证
        if (oldPassword == null || oldPassword.length() == 0) {
            throw new IllegalAccessException("请输入旧密码");
        }
        else if (newPassword == null || newPassword.length() == 0) {
            throw new IllegalAccessException("请输入新密码");
        }

        //验证合法性
        //判断旧密码是否正确

        //判断旧密码与新密码是否一致
        if (oldPassword.equals(newPassword)){
            throw new IllegalAccessException("新密码不能与旧密码相同");
        }
        //更新密码

        userDao.upDatePassWord(oldPassword);
    }
}