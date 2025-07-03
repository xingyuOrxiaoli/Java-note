package com.lxy.A04;

import com.lxy.pojo.Test1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class TestParamMethod {
    public static void main(String[] args) throws IOException {
        String resource = "com/lxy/A04/mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 添加
        System.out.println("==========="+"添加 数据"+"===========");
        int insert = sqlSession.insert("com.lxy.A04.mapper.CRUDMethod.insertTest1", new Test1(12, "username12", "password12"));
        System.out.println("insert :\t"+insert);
        sqlSession.commit(); // 提交
//        // 更新
        System.out.println("==========="+"更新 数据"+"===========");
        int update = sqlSession.update("com.lxy.A04.mapper.CRUDMethod.updateTest1", new Test1(12, "username12update", "password12update"));
        System.out.println("update :\t"+update);
        // 删除
        System.out.println("==========="+"删除 数据"+"===========");
        int delete = sqlSession.delete("com.lxy.A04.mapper.CRUDMethod.deleteTest1", new Test1(12, "username12", "password12"));
        System.out.println("delete :\t"+delete);

        // 查询
        System.out.println("==========="+"查询 数据"+"===========");
        List<Test1> objectList = sqlSession.selectList("com.lxy.A04.mapper.CRUDMethod.selectTest1");
        objectList.forEach(System.out::println);


        sqlSession.close();

    }
}
