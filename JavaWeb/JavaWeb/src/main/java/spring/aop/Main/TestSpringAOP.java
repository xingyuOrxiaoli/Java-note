package spring.aop.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aop.service.TestServiceAop;
import spring.aop.service.TestServiceAop1;

/**
 * 真实对象 :   要进行功能扩展的对象，相当于A对象
 * 代理对象 :   完成功能扩展的对象，相当于B对象
 * 切点    :   要进行功能扩展的方法，相当于testA()方法
 * 前置通知方法：在切点之前执行的扩展方法
 * 后置通知方法：在切点之前执行的扩展方法
 * 切面      ：由前置通知 + 切点 + 后置通知形成的横向执行的面
 * 织入      ：由前置通知 + 切点 + 后置通知形成切面的过程
 */
public class TestSpringAOP {
    public static void main(String[] args) {

        TestServiceAop testServiceAop = new TestServiceAop1();
        testServiceAop.testA();
        System.out.println("-------------------------------");

        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("spring/aop/applicationContext_AOP.xml");

        TestServiceAop testServiceAop1 = (TestServiceAop) applicationContext.getBean("testServiceAop1");
        testServiceAop1.testA();
        System.out.println("-------------------------------");
        testServiceAop1.testA("username1","password1");

        System.out.println("-------------------------------");
        testServiceAop1.testAJ("username2","uname2");

        System.out.println("------------  注解 -------------------");
        TestServiceAop testServiceAop2 = (TestServiceAop) applicationContext.getBean("testServiceAop2");
        testServiceAop2.testA();



    }
}
