package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findByPage.do")
   public  ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<User> list = userService.findAll();
        mv.addObject("userList",list);
        mv.setViewName("user-main");
        return mv;
    }

}
