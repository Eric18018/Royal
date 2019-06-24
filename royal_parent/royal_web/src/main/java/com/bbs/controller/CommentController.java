package com.bbs.controller;

import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment.do")
public class CommentController {
    @Autowired
    CommentService commentService;
}
