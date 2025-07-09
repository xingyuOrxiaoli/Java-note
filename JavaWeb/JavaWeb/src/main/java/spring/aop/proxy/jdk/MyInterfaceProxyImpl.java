package spring.aop.proxy.jdk;

public class MyInterfaceProxyImpl implements MyInterfaceProxy{
    @Override
    public void testJDKProxy() {
        System.out.println("-----  testJDKProxy   ------");
    }
}
