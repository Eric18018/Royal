package com.bbs.controller;

import com.bbs.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/word.do")
public class WordController {
    @Autowired
    WordService wordService;
}
