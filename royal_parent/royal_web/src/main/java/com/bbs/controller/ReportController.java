package com.bbs.controller;

import com.bbs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report.do")
public class ReportController {
    @Autowired
    ReportService reportService;
}
