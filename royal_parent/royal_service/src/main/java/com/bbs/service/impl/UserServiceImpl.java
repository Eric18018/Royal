package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 保存用户注册信息的方法
     *
     * @param user
     * @return
     */
    @Override
    public boolean saveRegister(User user) {
        User u = userDao.findByUsername(user.getUserName());
        if (u != null) {
            return false;
        }
        userDao.saveRegister(user);
        return true;
    }

    /**
     * 查询数据库是否有该用户名的方法
     *
     * @param username
     * @return
     */
/*    @Override
    public User findByUsername(String username) {

        return userDao.findByUsername(username);
    }*/


    /**
     * 后台通过用户名和角色查找所有用户
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<User> findUsernameAndRole(String name, String role,Integer page,Integer size) {
 /*       if (role != null || !"".equals(role) || name != null || !"".equals(name)) {
            PageHelper.startPage(page,size);
            return userDao.findByUsernameAndRole(name,role,page,size);
        }else {
            return userDao.findAllUser(name,role,page,size);*/
            PageHelper.startPage(page,size);
             return userDao.findByUsernameAndRole(name,role);
    }

    /**
     * 根据用户名和密码查询user对象的方法
     *
     * @param userName
     * @param userPass
     * @return
     */
    @Override
    public User findByNameAndPass(String userName, String userPass) {

        return userDao.findByNameAndPass(userName, userPass);
    }

    /**
     * 用户升级功能
     *
     * @param userId 用户id
     * @param role   用户级别
     * @return
     * @throws Exception
     */
    @Override
    public void updateByUserId(Integer userId, Integer role) throws Exception {
        Integer isupdating = 0; //升级申请
        Integer updateStatus = 0; //审核状态
        if (role == 1) {
            role = 2;
            isupdating = 1;
            updateStatus = 1;
        } else if (role == 2) {
            role = 1;
        }
        userDao.updateByUserId(isupdating, updateStatus, role, userId);
    }

    /**
     * 禁言功能
     *
     * @param userId     用户id
     * @param talkStatus 禁言状态
     * @return
     * @throws Exception
     */
    @Override
    public void stopByUserId(Integer userId, Integer talkStatus) throws Exception {
        if (talkStatus == 0) {
            talkStatus = 1;
        } else {
            talkStatus = 0;
        }
        userDao.stopByUserId(userId, talkStatus);
    }

    /**
     * 查询所有用户信息
     *
     * @param page 当前页码
     * @param size 每页数量
     * @return
     */
    @Override
    public List<User> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page, size);
        return userDao.findAll();
    }

    /**
     * 更改邮箱地址
     *
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
    public void updatePassWord(String oldPassword, String newPassword) throws Exception {
        //对参数进行非空验证
        if (oldPassword == null || oldPassword.length() == 0) {
            throw new IllegalAccessException("请输入旧密码");
        } else if (newPassword == null || newPassword.length() == 0) {
            throw new IllegalAccessException("请输入新密码");
        }

        //验证合法性
        //判断旧密码是否正确

        //判断旧密码与新密码是否一致
        if (oldPassword.equals(newPassword)) {
            throw new IllegalAccessException("新密码不能与旧密码相同");
        }
        //更新密码

        userDao.upDatePassWord(oldPassword);

    }

    /**
     * 处理自己的用户对象封装成UserDetails
     *
     * @param username 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInfo = userDao.findByUsername(username);


        //处理自己的用户对象封装成UserDetails
        org.springframework.security.core.userdetails.User user=new org.springframework.security.core.userdetails.User(userInfo.getUserName(),"{noop}"+userInfo.getUserPass(),getAuthority(userInfo.getRole()));

        return user;
    }

    //进行权限的字符串拼接
    private List<SimpleGrantedAuthority> getAuthority(Integer role) {
        List<SimpleGrantedAuthority> list = new ArrayList();
        list.add(new SimpleGrantedAuthority("ROLE_" + role));
        return list;
    }
}
