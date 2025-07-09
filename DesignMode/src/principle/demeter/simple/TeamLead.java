package principle.demeter.simple;

import java.util.ArrayList;
import java.util.List;

public class TeamLead {

    public void commandCheckNumber(Employee employee) {
        // Course并不是TeanLead的朋友类，这里违背了迪米特法则
        List<Course> courseList = new ArrayList<Course>();
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            courseList.add(course);
        }
        employee.checkNumberOfCourses(courseList);
    }
}
