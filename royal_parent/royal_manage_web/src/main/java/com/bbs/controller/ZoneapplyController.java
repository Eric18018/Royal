package com.bbs.controller;

import com.bbs.domain.Zoneapply;
import com.bbs.service.ZoneapplyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/zoneapply")
public class ZoneapplyController {
    @Autowired
    private ZoneapplyService zoneapplyService;

    /**
     * 查询所有的版块
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Zoneapply> zoneapplys = zoneapplyService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(zoneapplys);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("zoneapply-list");
        return mv;
    }

    /**
     * 版块的开通与关闭
     */
    @RequestMapping("/updateByApplyZoneId.do")
    public String updateByApplyZoneId(@RequestParam(name = "applyZoneId", required = true) Integer applyZoneId,
                                      @RequestParam(name = "status", required = true) Integer status) throws Exception {
        zoneapplyService.updateByApplyZoneId(applyZoneId, status);
        return "redirect:findAll.do";
    }

    /**
     * 根据applyZoneId 删除版块申请信息
     */
    @RequestMapping("/deleteByApplyZoneId.do")
    public String deleteByApplyZoneId(@RequestParam(name = "applyZoneId", required = true) Integer applyZoneId) throws Exception {
        zoneapplyService.deleteByApplyZoneId(applyZoneId);
        return "redirect:findAll.do";
    }
}
