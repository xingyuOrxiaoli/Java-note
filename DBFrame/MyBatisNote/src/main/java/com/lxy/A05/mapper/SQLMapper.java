package com.lxy.A05.mapper;

import com.lxy.pojo.Test1;

import java.util.List;

public interface SQLMapper {

    public List<Test1> selectSQLTest1(int id , String username);
    public List<Test1> selectSQLTest2(int id , String username);
    public List<Test1> selectSQLTest3(List<Integer> list);
    public List<Test1> selectSQLTest4(int[] arr);
    public List<Test1> selectSQLTest5(String username);

    public int updateSQLTest1(Test1 test1);
    public int updateSQLTest2(Test1 test1);
    public int deleteSQLTest1(Test1 test1);
    public int insertSQLTest1(Test1 test1);
}
