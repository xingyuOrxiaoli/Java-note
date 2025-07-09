package spring.ioc.entity;

public class StudentFactory {

    public Student newIntance(){
        Student student = new Student();
        student.setUsername("username 动态工厂");
        return student;
    }
}
