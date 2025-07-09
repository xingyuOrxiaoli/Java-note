package principle.dependencyinversion;

public class Student_V1 {
    public static void main(String[] args) {
        Student_V1 studentV1 = new Student_V1();
        studentV1.study(new JavaCourseV1());
        studentV1.study(new PythonCourseV1());
    }
    public void study(ICourseV1 iCourse) {
        iCourse.study();
    }
}

interface ICourseV1{
    void study();
}

class JavaCourseV1 implements ICourseV1{
    @Override
    public void study() {
        System.out.println("学习Java课程");
    }
}

class PythonCourseV1 implements ICourseV1{
    @Override
    public void study() {
        System.out.println("学习python课程");
    }
}