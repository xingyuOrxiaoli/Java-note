package com.xiaoli.controller;

import com.xiaoli.annotation.NotIncludeSwagger;
import com.xiaoli.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/my")
@Api(tags = {"用户接口","MyController"} , description = "描述" )
public class MyController {

    @RequestMapping(value = "/getUser" , method= RequestMethod.GET)
    /**
     * name         属性名
     * value        描述
     * required     是否必须
     * paramType    属性类型
     * dataType     数据类型
     */
    @ApiImplicitParam(name="")
    @ApiOperation(value="获取用户列表，接口描述" , notes = "接口提示信息")
    // ApiParam -> required  必须的
    // ApiParam -> value     参数描述
    // ApiParam -> name      参数名称
    public User getUser( Integer id , @ApiParam(value="用户名" , required = true) String username){
        User user = new User(id, username, "password", 10);
        return user;
    }

    @NotIncludeSwagger
    @RequestMapping(value = "/getUser2" ,method= RequestMethod.GET)
    @ApiOperation(value="获取用户列表2,接口描述")
    public User getUser2(Integer id , String username){
        User user = new User(id, username, "password", 10);
        return user;
    }
}
