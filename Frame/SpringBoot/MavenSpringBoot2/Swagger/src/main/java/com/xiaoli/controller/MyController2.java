package com.xiaoli.controller;

import com.xiaoli.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
@Api(tags = "用户接口")
public class MyController {

    @RequestMapping(value = "/getUser" ,method= RequestMethod.GET)
    @ApiOperation("获取用户列表")
    public User getUser(Integer id , String username){
        User user = new User(id, username, "password", 10);
        return user;
    }
}
