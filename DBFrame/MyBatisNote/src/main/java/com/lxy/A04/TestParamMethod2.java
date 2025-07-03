package com.lxy.A04;

import com.lxy.A04.mapper.CRUD2Interface;
import com.lxy.pojo.Test1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestParamMethod2 {
    public static void main(String[] args) throws IOException {
        String resource = "com/lxy/A04/mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CRUD2Interface mapper = sqlSession.getMapper(CRUD2Interface.class);

        // 添加
        System.out.println("==========="+" mapper代理 添加 数据"+"===========");
        int insert = mapper.insertTest1(new Test1(14, "username14", "password14"));
        System.out.println("insert :\t"+insert);

        // 更新
        System.out.println("==========="+"mapper代理 更新 数据"+"===========");
        int update = mapper.updateTest1(new Test1(14, "username14update", "password14update"));
        System.out.println("update :\t"+update);
//        // 删除
        System.out.println("==========="+"mapper代理 删除 数据"+"===========");
        int delete = mapper.deleteTest1(new Test1(14, "username14", "password14"));
        System.out.println("delete :\t"+delete);

        // 查询
        System.out.println("==========="+"mapper代理 查询 数据"+"===========");
        List<Test1> objectList = mapper.selectTest1();
        objectList.forEach(System.out::println);


        sqlSession.close();

    }
}
