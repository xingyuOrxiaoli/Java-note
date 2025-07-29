package com.xiaoli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InterceptorController {

    @ResponseBody
    @RequestMapping("/demo1")
    public String demo1(){
        return "demo1";
    }

    @ResponseBody
    @RequestMapping("/demo2")
    public String demo2(){
        return "demo2";
    }
}
