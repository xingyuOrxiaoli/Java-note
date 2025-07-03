package com.lxy.A05;

import com.lxy.A05.mapper.SQLMapper;
import com.lxy.pojo.Test1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestSQL {
    public static void main(String[] args) throws IOException {
        String resource = "com/lxy/A05/mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);

        System.out.println("==========="+" 动态SQL 使用IF语句   id= id and username=username"+"===========");
        List<Test1> list = mapper.selectSQLTest1(1, "");
        list.forEach(System.out::println);

        System.out.println("==========="+" 动态SQL 使用choose when语句  id= id or username=username 不同于if，只要满足一个直接跳出choose"+"===========");
        list = mapper.selectSQLTest2(0, "");
        list.forEach(System.out::println);

        System.out.println("==========="+" 动态SQL 使用foreach 语句 集合为 list  数组为 array 关键字  MyBatis自动封装到map中"+"===========");
        List<Integer> ids = new ArrayList<>();
        Collections.addAll(ids,1,2,3);
        list = mapper.selectSQLTest3(ids);
        list.forEach(System.out::println);

        System.out.println("==========="+" 动态SQL 使用foreach 语句 集合为 list  数组为 array 关键字  MyBatis自动封装到map中"+"===========");
        int[] arr = {4,5,6};
        list = mapper.selectSQLTest4(arr);
        list.forEach(System.out::println);

        System.out.println("==========="+" 动态SQL 使用bind 语句 "+"===========");
        list = mapper.selectSQLTest5("JDBCI");
        list.forEach(System.out::println);

        System.out.println("==========="+" 动态SQL 使用set关键字 添加set 并自动去除最后一个,逗号"+"===========");
        int update = mapper.updateSQLTest1(new Test1(1,"username1Update","password1Update"));
        System.out.println("update : \t"+update);

        System.out.println("==========="+" 动态SQL 使用trim关键字 对前缀后缀的删除和添加"+"===========");
        update = mapper.updateSQLTest2(new Test1(1,"username1UpdateTrim","password1UpdateTrim"));
        System.out.println("update : \t"+update);
        sqlSession.close();

    }
}
