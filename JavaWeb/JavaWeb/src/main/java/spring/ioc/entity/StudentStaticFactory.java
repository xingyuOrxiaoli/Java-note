package spring.ioc.entity;

public class StudentStaticFactory {

    public static Student newIntance(){
        Student student = new Student();
        student.setUsername("username 静态工厂");
        return student;
    }
}
