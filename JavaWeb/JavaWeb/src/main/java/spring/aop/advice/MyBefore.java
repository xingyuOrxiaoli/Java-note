package spring.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        // 调入切点
        method.invoke(target,args);

        System.out.println("MyBefore implements MethodBeforeAdvice :扩展前 。 method : " + method.getClass() +"args : "+ args[0]);
    }
}
