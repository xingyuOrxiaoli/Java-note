package spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class MyThrow implements ThrowsAdvice {

    public void afterThrowing(Exception e){
        System.out.println("异常通知 " + e.getMessage());
    }
}
