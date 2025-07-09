package principle.demeter.change;

import java.util.ArrayList;
import java.util.List;

public class Employee {


    public void checkNumberOfCourses() {
        List<Course> courseList = new ArrayList<Course>();
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            courseList.add(course);
        }
        System.out.println("目前发布的课程数量为:" + courseList.size());
    }
}
