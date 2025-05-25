package collection;

import java.util.Objects;

public class Student
        implements Comparable<Student>

{

    @Override
    public int compareTo(Student o) {

        // 按照学号从小到大
        return this.sno - o.sno;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sno == student.sno && age == student.age && Double.compare(score, student.score) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sno, name, age, score);
    }
    private int sno;
    private String name;
    private int age;
    private double score;

    public Student(int sno, String name, int age, double score) {
        this.sno = sno;
        this.name = name;
        this.age = age;
        this.score = score;
    }


    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public int getSno() {
        return sno;
    }
}
