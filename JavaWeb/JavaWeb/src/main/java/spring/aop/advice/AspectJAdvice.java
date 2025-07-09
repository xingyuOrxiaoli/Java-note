package spring.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

public class AspectJAdvice {

    // 前置通知
    public void before(){
        //  String username , String uname
        //  Method method , Object[] objects , Object o
        System.out.println("AspectJAdvice before 前置通知。");
//        System.out.println("AspectJAdvice before 前置通知。 username =  "+ username +"\t uname = "+ uname);
    }
    // 后置通知
    public void after(){
        System.out.println("AspectJAdvice after  后置通知");
    }
    // 环绕通知
    public void myRound(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 环绕前
        System.out.println("环绕 - 前");
        // 放行
        Object proceed = proceedingJoinPoint.proceed();
        // 环绕后
        System.out.println("环绕 - 前");
    }
    // 异常通知
    public void myThrow(Exception e){
        System.out.println("AJ异常通知");
    }


}
