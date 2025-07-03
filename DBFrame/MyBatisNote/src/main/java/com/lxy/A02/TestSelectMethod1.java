package com.lxy.A02;

import com.lxy.pojo.Test1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class TestSelectMethod1 {
    public static void main(String[] args) throws IOException {
        String resource = "com/lxy/A02/mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 查询方法一
        System.out.println("==========="+"查询方法一"+"===========");
        List<Test1> objectList = sqlSession.selectList("com.lxy.A02.mapper.SelectMethod1.selectTest1");
        objectList.forEach(System.out::println);

        // 查询方法二
        System.out.println("==========="+"查询方法二"+"===========");
        Test1 test1 = sqlSession.selectOne("com.lxy.A02.mapper.SelectMethod1.selectTest2");
        System.out.println(test1);

        // 查询方法三
        System.out.println("==========="+"查询方法三"+"===========");
        Map<Object, Object> map = sqlSession.selectMap("com.lxy.A02.mapper.SelectMethod1.selectTest1", "id");
        map.forEach((key,value)-> System.out.println(key +"\t"+value));


        sqlSession.close();

    }
}
