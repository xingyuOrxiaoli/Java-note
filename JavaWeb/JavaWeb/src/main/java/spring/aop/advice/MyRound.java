package spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyRound implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 扩展前代码
        System.out.println("环绕通知  --- 前");
        Object proceed = invocation.proceed();
        System.out.println("环绕通知  --- 后");

        return proceed;

    }
}
