package principle.simpleresponsibility.simple;

public class Course {

    public void study(String courseName) {
        if("Java课程" .equals(courseName)){
            System.out.println("学习Java");
        }else{
            System.out.println("学习AI");
        }
    }
}
