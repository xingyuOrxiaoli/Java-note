package com.lxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test1AndTest2 {
    private int test1Id;
    private String test1UserName;
    private String test1Password;
    private int test2Id;
    private String test2UserName;
    private String test2Password;
    private Date test2Date;
}
