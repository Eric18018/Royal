package com.bbs.controller;

import com.bbs.domain.Word;
import com.bbs.service.WordService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;

    /**
     * 查询所有敏感词汇
     *
     * @param page 总页数
     * @param size 当前页数量
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Word> words = wordService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(words);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("word-list");
        return mv;
    }

    /**
     * 敏感词汇开启关闭功能
     */
    @RequestMapping("/updateBywordId.do")
    public String updateBywordId (@RequestParam(name = "wordId", required = true) Integer wordId,
                                  @RequestParam(name = "status", required = true) Integer status) throws Exception{
        wordService.updateBywordId(wordId,status);
        return "redirect:findAll.do";
    }
}
