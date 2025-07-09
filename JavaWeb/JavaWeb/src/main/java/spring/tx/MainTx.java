package spring.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.mybatis.entity.Student;
import spring.mybatis.mapper.StudentMapper;

public class MainTx {
    public static void main(String[] args) {
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("spring/tx/applicationContextTX.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        int index = 9 ;
        System.out.println(studentService.insert(new Student(index + "", index, "username" + index, "password" + index, "男", 1)));

    }
}
