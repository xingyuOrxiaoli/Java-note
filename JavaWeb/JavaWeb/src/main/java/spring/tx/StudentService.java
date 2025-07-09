package spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.mybatis.entity.Student;
import spring.mybatis.mapper.StudentMapper;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;
    public int insert(Student student){
        int insert = studentMapper.insert(student);
//        int i = 1 / 0 ;
        return insert;
    }
}
