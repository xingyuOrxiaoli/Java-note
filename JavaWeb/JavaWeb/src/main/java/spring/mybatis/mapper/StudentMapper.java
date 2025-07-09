package spring.mybatis.mapper;


import org.apache.ibatis.annotations.Insert;
import spring.mybatis.entity.Student;

import java.util.List;

public interface StudentMapper {
    public List<Student> selectAll();

    @Insert("insert into student values(#{sno},#{id},#{username},#{password},#{sex},#{classId})")
    public int insert(Student student);
}
