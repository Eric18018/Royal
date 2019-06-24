package com.bbs.controller;

import com.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/reply.do")
public class ReplyController {
@Autowired
    ReplyService replyService;

}
