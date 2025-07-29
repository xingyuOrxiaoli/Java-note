package com.xiaoli.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User2 {
    private Integer id;

    private String name;

    private Integer age;

    private User user;


}
