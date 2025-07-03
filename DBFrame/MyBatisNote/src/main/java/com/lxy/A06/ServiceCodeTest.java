package com.lxy.A06;

import com.lxy.A06.mapper.N1Mapper;
import com.lxy.A06.mapper.ServiceCodeMapper;
import com.lxy.pojo.Test1;
import com.lxy.pojo.Test2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServiceCodeTest {
    public static void main(String[] args) throws IOException {
        String resource = "com/lxy/A06/mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ServiceCodeMapper mapper = sqlSession.getMapper(ServiceCodeMapper.class);

        List<Test2> res = mapper.selectServiceCodeTest2();

        for (Test2 item : res) {
            Test1 test1 = mapper.selectOneTest1(item.getId());
            item.setTest1(test1);

            List<Test1> list = mapper.selectMoreTest1(item.getId());
            item.setTest1List(list);
        }

        res.forEach(System.out::println);
        sqlSession.close();
    }
}
