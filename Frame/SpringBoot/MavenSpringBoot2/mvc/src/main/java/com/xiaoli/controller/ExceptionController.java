package com.xiaoli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public String xiaoliException(){
        return "出错了 执行全局";
    }


}
