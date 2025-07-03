package com.lxy.A06.mapper;

import com.lxy.pojo.Test1;
import com.lxy.pojo.Test2;

import java.util.List;

public interface ServiceCodeMapper {

    public Test1 selectOneTest1(int id);

    public List<Test1> selectMoreTest1(int id);
    public List<Test2> selectServiceCodeTest2();


}
