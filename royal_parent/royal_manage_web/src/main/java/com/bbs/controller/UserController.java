package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user.do")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
   public  ModelAndView findAll(String userName){
        ModelAndView mv = new ModelAndView();
        List<User> list = userService.findAll(userName);
        mv.addObject("user_list",list);
        mv.setViewName("");
        return mv;
    }

}
