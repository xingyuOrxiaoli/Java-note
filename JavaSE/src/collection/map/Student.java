package collection.map;

import java.util.Objects;

public class Student
        implements Comparable<Student>
{

    private int sno;
    private String name;
    public Student(int sno, String name) {
        this.sno = sno;
        this.name = name;
    }
    @Override
    public int compareTo(Student o) {
        return this.sno - o.sno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sno == student.sno && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sno, name);
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }
}