package spring.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectJAdviceAnnoation {

    // 前置通知
    @Before("execution(* spring.aop.service.TestServiceAop2.testA())")
    public void before(){
        //  String username , String uname
        //  Method method , Object[] objects , Object o
        System.out.println("注解 AspectJAdvice before 前置通知。");
//        System.out.println("AspectJAdvice before 前置通知。 username =  "+ username +"\t uname = "+ uname);
    }
    // 后置通知
    @After("execution(* spring.aop.service.TestServiceAop2.testA())")
    public void after(){
        System.out.println("注解 AspectJAdvice after  后置通知");
    }
    // 环绕通知
    @Around("execution(* spring.aop.service.TestServiceAop2.testA())")
    public void myRound(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 环绕前
        System.out.println("注解 环绕 - 前");
        // 放行
        Object proceed = proceedingJoinPoint.proceed();
        // 环绕后
        System.out.println("注解 环绕 - 前");
    }
    // 异常通知
    @AfterThrowing(value = "execution(* spring.aop.service.TestServiceAop2.testA())" ,throwing = "e")
    public void myThrow(Exception e){
        System.out.println("注解 AJ异常通知");
    }


}
