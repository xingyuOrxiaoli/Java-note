package com.lxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test2 {
    private int id;
    private String username;
    private String password;
    private Date createtime;
    private List<Test1> test1List;
    private Test1 test1;
}
