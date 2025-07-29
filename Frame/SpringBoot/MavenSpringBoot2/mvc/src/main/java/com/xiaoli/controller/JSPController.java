package com.xiaoli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/jsp", method = RequestMethod.GET)
public class JSPController {

    @RequestMapping(value = "{uri}", method = RequestMethod.GET)
    public String getJSP(@PathVariable(value = "uri") String uri){
        System.out.println(uri);
        return uri;
    }

}
