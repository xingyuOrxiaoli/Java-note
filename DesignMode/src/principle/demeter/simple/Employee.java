package principle.demeter.simple;

import java.util.List;

public class Employee {
    public void checkNumberOfCourses(List<Course> courseList) {
        System.out.println("目前发布的课程数量为:" + courseList.size());
    }
}
