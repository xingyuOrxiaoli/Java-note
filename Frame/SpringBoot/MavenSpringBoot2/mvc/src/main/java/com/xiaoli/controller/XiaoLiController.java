package com.xiaoli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/xiaoli", method = RequestMethod.GET)
@RestController
public class XiaoLiController {

    @RequestMapping(value = "/testOne", method = RequestMethod.GET)
    public String testOne(){
        return "123";
    }

}
