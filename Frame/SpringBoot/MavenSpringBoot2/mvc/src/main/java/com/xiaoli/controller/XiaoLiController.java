package com.xiaoli.controller;

import com.xiaoli.pojo.Test1;
import com.xiaoli.service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/xiaoli", method = RequestMethod.GET)
public class XiaoLiController {

    @Autowired
    private Test1Service test1Service;

    @RequestMapping(value = "/testOne", method = RequestMethod.GET)
    public String testOne(){
        return "123";
    }

    @RequestMapping(value = "/findAlLTest", method = RequestMethod.GET)
    public List<Test1> findAlLTest(Integer id,String username){
        System.out.println(id +"\t" + username);

        return test1Service.findTest1All();
    }


}
