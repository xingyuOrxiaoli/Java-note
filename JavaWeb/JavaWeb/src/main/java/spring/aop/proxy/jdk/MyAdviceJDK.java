package spring.aop.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyAdviceJDK implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("使用JDK动态代理 -- 扩展前");
        MyInterfaceProxyImpl myInterfaceProxy = new MyInterfaceProxyImpl();
        myInterfaceProxy.testJDKProxy();
        System.out.println("使用JDK动态代理 -- 扩展后");

        return null;
    }
}
