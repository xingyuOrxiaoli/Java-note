package com.lxy.A06;

import com.lxy.A05.mapper.SQLMapper;
import com.lxy.A06.mapper.N1Mapper;
import com.lxy.pojo.Test2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class N1Select {
    public static void main(String[] args) throws IOException {
        String resource = "com/lxy/A06/mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        N1Mapper mapper = sqlSession.getMapper(N1Mapper.class);
        List<Test2> res = mapper.selectN1Test1();
        res.forEach(System.out::println);

        sqlSession.close();
    }
}
