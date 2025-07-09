package spring.ioc.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.entity.Student;
import spring.ioc.entity.StudentPrototype;
import spring.ioc.entity.StudentSingleton;
import spring.ioc.service.TestService;

public class Main_TestService {
    public static void main(String[] args) {

        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("spring/ioc/applicationContext.xml");
        TestService testService = (TestService) applicationContext.getBean("testService");
        testService.testService();

        Student student_constructor = (Student) applicationContext.getBean("student_constructor");
        System.out.println("使用构造方法创建学生对象："+student_constructor);
        Student student_get_set = (Student) applicationContext.getBean("student_get_set");
        System.out.println("使用get/set创建学生对象："+student_get_set);
        Student student_factory_new = (Student) applicationContext.getBean("student_factory_new");
        System.out.println("使用动态工厂创建学生对象 ："+student_factory_new);
        Student student_static_factory_new = (Student) applicationContext.getBean("student_static_factory_new");
        System.out.println("使用静态工厂创建学生对象："+student_static_factory_new);

        System.out.println("----------------------------------------------------------------");
        StudentSingleton student_scope_singleton1 = (StudentSingleton) applicationContext.getBean("student_scope_singleton");
        student_scope_singleton1.setId(1);
        System.out.println("单例创建学生对象1 ："+student_scope_singleton1);
        StudentSingleton student_scope_singleton2 = (StudentSingleton) applicationContext.getBean("student_scope_singleton");
        System.out.println("单例创建学生对象2 ："+student_scope_singleton2);

        StudentPrototype student_scope_prototype1 = (StudentPrototype) applicationContext.getBean("student_scope_prototype");
        student_scope_prototype1.setId(1);
        System.out.println("多例创建学生对象1 ："+student_scope_prototype1);
        StudentPrototype student_scope_prototype2 = (StudentPrototype) applicationContext.getBean("student_scope_prototype");
        System.out.println("多例创建学生对象2 ："+student_scope_prototype2);


    }
}
