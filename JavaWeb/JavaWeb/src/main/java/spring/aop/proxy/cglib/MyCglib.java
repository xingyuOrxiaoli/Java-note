package spring.aop.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import spring.aop.proxy.jdk.MyInterfaceProxyImpl;

import java.lang.reflect.Method;

public class MyCglib implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("使用cglib动态代理 -- 扩展前");

        methodProxy.invokeSuper(o,objects);

        System.out.println("使用cglib动态代理 -- 扩展后");

        return null;
    }
}
