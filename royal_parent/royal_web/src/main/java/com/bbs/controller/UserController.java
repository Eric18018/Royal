package com.bbs.controller;

import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user.do")
public class UserController {
    @Autowired
    UserService userService;
}
