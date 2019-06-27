package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户信息
     *
     * @param page 当前页码
     * @param size 每页数量
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<User> users = userService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(users);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("user-main");
        return mv;
    }

    /**
     * 用户升级功能
     * @param userId  用户id
     * @param role    用户级别
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateByUserId.do")
    public String updateByUserId(@RequestParam(name = "userId", required = true) Integer userId,
                                    @RequestParam(name = "role", required = true) Integer role) throws Exception {
        userService.updateByUserId(userId,role);
        return "redirect:findAll.do";
    }

    /**
     * 禁言功能
     * @param userId        用户id
     * @param talkStatus    禁言状态
     * @return
     * @throws Exception
     */
    @RequestMapping("/stopByUserId.do")
    public  String stopByUserId(@RequestParam(name = "userId", required = true) Integer userId,
                                @RequestParam(name = "talkStatus", required = true) Integer talkStatus) throws Exception {
        userService.stopByUserId(userId,talkStatus);
        return "redirect:findAll.do";
    }
}
