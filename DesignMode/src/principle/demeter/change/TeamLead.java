package principle.demeter.change;

import java.util.ArrayList;
import java.util.List;

public class TeamLead {

    public void commandCheckNumber(Employee employee) {

        employee.checkNumberOfCourses();
    }
}
