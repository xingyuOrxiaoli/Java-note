package com.xiaoli.controller;

import com.xiaoli.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my2")
@Api(tags = "用户接口2")
public class MyController2 {

    @RequestMapping(value = "/get2User" ,method= RequestMethod.GET)
    @ApiOperation("获取用户列表")
    public User get2User(Integer id , String username){
        User user = new User(id, username, "password", 10);
        return user;
    }
}
