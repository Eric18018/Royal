package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
