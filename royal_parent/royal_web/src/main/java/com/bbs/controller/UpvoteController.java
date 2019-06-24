package com.bbs.controller;

import com.bbs.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upvoteController")
public class UpvoteController {
    @Autowired
    UpvoteService upvoteService;
}
