package com.mycat.micro.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Desc:首页
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
