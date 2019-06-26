package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;




    //更改邮箱地址
    @RequestMapping("updateEmail.do")
    public String updateEmail(User user) throws Exception {
        userService.updateEmail(user);
        return "user_info";

    }

    /**
     * 保存用户注册信息的方法
     *
     * @param user
     * @return
     */

    @RequestMapping("/saveRegister.do")
    @ResponseBody
    public String saveRegister(User user,HttpServletRequest request) {

        try {
            user.setRole(1);
            user.setLastLoginTime(new Date());
            user.setLoginStatus(1);
            user.setTalkStatus(0);
            user.setIsupdating(0);
            userService.saveRegister(user);
            request.getSession().setAttribute("user",user);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    /**
     * 查询数据库是否有该用户名的方法
     *
     * @param username
     * @return
     */
    @RequestMapping("/findByUsername.do")
    @ResponseBody
    public String findByUsername(String username) {
        if (userService.findByUsername(username) == null) {
            return "true";
        }
        return "false";
    }

    /**
     * 根据用户名和密码查询user对象的方法
     * @param userName
     * @param userPass
     * @return
     */
    @RequestMapping("/login.do")
    public String findByNameAndPass(String userName, String userPass,HttpServletRequest request) {
        User user = userService.findByNameAndPass(userName, userPass);
        if (user == null) {
            return null;
        } else {
            request.getSession().setAttribute("user", user);
            return "redirect:/index.jsp";
        }
    }

    @RequestMapping("/logout.do")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:/index.jsp";
    }
}
