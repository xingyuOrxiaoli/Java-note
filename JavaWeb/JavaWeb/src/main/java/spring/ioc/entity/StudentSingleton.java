package spring.ioc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSingleton implements Serializable {
    private String sno;

    private Integer id;

    private String username;

    private String password;

    private String sex;

    private Integer classId;

//    public Student(String sno, Integer id, String username, String password, String sex, Integer classId) {
//        this.sno = sno;
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.sex = sex;
//        this.classId = classId;
//    }

    public StudentSingleton(int id, String sex, int classId) {
        this.id = id;
        this.sex = sex;
        this.classId = classId;
    }

    public Object gain_address(){
        return super.toString();
    }
}
