package principle.dependencyinversion;

// 构造器注入方式
public class Student_V2 {
    public static void main(String[] args) {
        Student_V2 studentV2 = new Student_V2(new JavaCourseV2());
        studentV2.study();
    }
    private ICourseV2 course;
    public Student_V2(ICourseV2 course) {
        this.course = course;
    }
    public void study() {
        this.course.study();
    }

}

interface ICourseV2{
    void study();
}

class JavaCourseV2 implements ICourseV2{
    @Override
    public void study() {
        System.out.println("学习Java课程");
    }
}

class PythonCourseV2 implements ICourseV2{
    @Override
    public void study() {
        System.out.println("学习python课程");
    }
}