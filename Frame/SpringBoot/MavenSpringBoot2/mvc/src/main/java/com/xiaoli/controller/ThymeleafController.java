package com.xiaoli.controller;

import com.xiaoli.pojo.Test1;
import com.xiaoli.service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/thymeleaf", method = RequestMethod.GET)
public class ThymeleafController {


    @Autowired
    private Test1Service test1Service;
    @RequestMapping(value = "{uri}", method = RequestMethod.GET)
    public String getThymeleaf(@PathVariable String uri , HttpServletRequest request){


        List<Test1> test1All = test1Service.findTest1All();

        request.setAttribute("test1All",test1All);
        request.setAttribute("name","request");
        HttpSession session = request.getSession();
        session.setAttribute("name","session");

        return uri;
    }
}
