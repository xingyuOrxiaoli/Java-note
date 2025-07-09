package spring.mybatis.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.mybatis.mapper.StudentMapper;

public class Main_TestMyBatis {
    public static void main(String[] args) {

        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("spring/mybatis/applicationContext_MyBatis.xml");

        StudentMapper StudentMapper = applicationContext.getBean("studentMapper", StudentMapper.class);
        StudentMapper.selectAll().forEach(System.out::println);

    }
}
