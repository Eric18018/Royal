package com.bbs.controller;

import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/zoneController")
public class ZoneController {
    @Autowired
    ZoneService zoneService;
}
