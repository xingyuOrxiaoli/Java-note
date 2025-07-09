package principle.demeter.simple;

public class LodTest {

    public static void main(String[] args) {
        TeamLead teamLead = new TeamLead();
        Employee employee = new Employee();
        teamLead.commandCheckNumber(employee);
    }
}
