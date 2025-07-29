package com.xiaoli.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@ApiModel(value="名称" , description = "描述")
public class User {

    /**
     * value     描述
     * name      重写属性名
     * required  是否必须
     * example  示例内容
     * hidden   是否隐藏
     */
    private Integer id ;
    @ApiModelProperty(value="描述", name = "name")
    private String username;
    private String password;
    private Integer age;


}
