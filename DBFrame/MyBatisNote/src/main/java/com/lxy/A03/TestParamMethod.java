package com.lxy.A03;

import com.lxy.pojo.Test1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestParamMethod {
    public static void main(String[] args) throws IOException {
        String resource = "com/lxy/A03/mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 参数传递传递一
        System.out.println("==========="+"参数传递传递一 : 单个参数  #{param1}  ? 占位符 ${param} $符号是拼接"+"===========");
        List<Test1> objectList = sqlSession.selectList("com.lxy.A03.mapper.ParamMethod.selectTest1",1);
        objectList.forEach(System.out::println);

        // 参数传递传递二
        System.out.println("==========="+"参数传递传递二 : 传递对象  #{param1}  ? 占位符 ${param} $符号是拼接 #{arg0} 不写参数类型也可以"+"===========");
        objectList = sqlSession.selectList("com.lxy.A03.mapper.ParamMethod.selectTest2",new Test1(2,"username2","password2"));
        objectList.forEach(System.out::println);


        // 参数传递传递三
        System.out.println("==========="+"参数传递传递二 : 传递map集合  #{param1}  ? 占位符 ${param} $符号是拼接"+"===========");
        HashMap<String,String> map = new HashMap<>();
        map.put("id","3");
        map.put("username","username3");

        objectList = sqlSession.selectList("com.lxy.A03.mapper.ParamMethod.selectTest3",map);
        objectList.forEach(System.out::println);



        sqlSession.close();

    }
}
