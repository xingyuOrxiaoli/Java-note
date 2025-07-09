package principle.simpleresponsibility.interfaceds;

interface ICourseInfo{
    // 课程学习或者更改学习课程
    void studyCourse();
    void changeCourse();
}

interface ICourseManager{
    // 管理课程
    String getCourseName();
    byte[] getCourseData();

}
public class CourseImpl implements ICourseManager , ICourseInfo{
    @Override
    public void studyCourse() {

    }

    @Override
    public void changeCourse() {

    }

    @Override
    public String getCourseName() {
        return "";
    }

    @Override
    public byte[] getCourseData() {
        return new byte[0];
    }
}
