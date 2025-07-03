package com.lxy.A04.mapper;

import com.lxy.pojo.Test1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CRUD2Interface {

    public int insertTest1(@Param("test1") Test1 test1);
    public int updateTest1(Test1 test1);
    public int deleteTest1(Test1 test1);
    public List<Test1> selectTest1();
}
