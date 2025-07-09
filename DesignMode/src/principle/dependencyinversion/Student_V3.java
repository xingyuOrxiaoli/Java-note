package principle.dependencyinversion;

// Setter方式注入进行注入
public class Student_V3 {
    public static void main(String[] args) {
        Student_V3 studentV3 = new Student_V3();
        studentV3.setCourse(new JavaCourseV3());
        studentV3.study();
    }
    private ICourseV3 course;
    public void setCourse(ICourseV3 course) {
        this.course = course;
    }
    public void study() {
        this.course.study();
    }

}

interface ICourseV3{
    void study();
}

class JavaCourseV3 implements ICourseV3{
    @Override
    public void study() {
        System.out.println("学习Java课程");
    }
}

class PythonCourseV3 implements ICourseV3{
    @Override
    public void study() {
        System.out.println("学习python课程");
    }
}