package com.xiaoli.controller;

import com.xiaoli.pojo.Test1;
import com.xiaoli.service.PagehelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/pagehelper",method = RequestMethod.GET)
public class PagehelperController {

    @Autowired
    private PagehelperService pagehelperService;

    @RequestMapping(value="/selPageService",method = RequestMethod.GET)
    public List<Test1> selPageService(){
        return pagehelperService.findTest1InfoPage();
    }


}
