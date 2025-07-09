package spring.aop.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class TestProxyCglib {
    public static void main(String[] args) {
        // 使用cglib动态生成代理对象
        Enhancer enhancer = new Enhancer();  // 创建 cglib对象
        enhancer.setSuperclass(MyCglibExtends.class); // 动态生成的代理对象需要继承的真实对象
        enhancer.setCallback(new MyCglib()); // 动态生成的代理对象要调用的代码
        MyCglibExtends myCglibExtends = (MyCglibExtends) enhancer.create(); // 生成代理对象
        myCglibExtends.testCglibExtends();

    }
}
