package com.xiaoli.mapper;

import com.xiaoli.pojo.Test1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Test1Mapper {

//    @Select("select * from test1")
    List<Test1> selectTest1All();
}
