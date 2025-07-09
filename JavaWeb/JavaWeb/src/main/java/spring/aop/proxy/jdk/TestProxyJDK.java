package spring.aop.proxy.jdk;

import java.lang.reflect.Proxy;

public class TestProxyJDK {
    public static void main(String[] args) {
        MyInterfaceProxy myInterfaceProxy = (MyInterfaceProxy) Proxy.newProxyInstance(
                TestProxyJDK.class.getClassLoader(),   // 类加载器，加载动态生成的代理对象
                new Class[]{MyInterfaceProxy.class},  // 动态生成的代理对象要实现的接口
                new MyAdviceJDK());   // 动态生成的代理对象自动调用的扩展代码 InvocationHandler 接口的实例

        // 调用代理对象
        myInterfaceProxy.testJDKProxy();

    }
}
