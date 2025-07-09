package principle.simpleresponsibility.interfaced;

interface ICourse {
    // 管理课程
    String getCourseName();
    byte[] getCourseData();

    // 课程学习或者更改学习课程
    void studyCourse();
    void changeCourse();
}

public class CourseImpl implements ICourse{
    @Override
    public String getCourseName() {
        return "";
    }

    @Override
    public byte[] getCourseData() {
        return new byte[0];
    }

    @Override
    public void studyCourse() {

    }

    @Override
    public void changeCourse() {

    }
}

