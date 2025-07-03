package com.lxy.A01;

import com.lxy.pojo.Test1;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.naming.spi.ObjectFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1A01 {
    public static void main(String[] args) throws IOException {
        String resource = "com/lxy/A01/mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);

        // 获取 session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获得 session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<Test1> objectList = sqlSession.selectList("com.lxy.A01.mapper.Test1Mapper.selectTest2");
        objectList.forEach(System.out::println);

        sqlSession.close();

    }
}
