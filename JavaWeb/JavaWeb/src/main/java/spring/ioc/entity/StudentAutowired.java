package spring.ioc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentAutowired implements Serializable {
    private String sno;

    private Integer id;

    private String username;

    private String password;

    private String sex;

    private Integer classId;

}
