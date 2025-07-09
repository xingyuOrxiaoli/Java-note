package principle.dependencyinversion;

// 场景代码
public class Student {
    public void studyJavaCourse() {
        System.out.println("学习Java课程");
    }
    public void studyPythonCourse() {
        System.out.println("学习Python课程");
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.studyPythonCourse();
        student.studyJavaCourse();
    }
}
