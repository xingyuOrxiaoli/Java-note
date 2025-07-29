package com.xiaoli;

import com.xiaoli.mapper.UserMapper;
import com.xiaoli.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = MongoDBApplication.class)
public class TestMongoDB {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        int n = 1;
        User user = new User(n,n +"" , "username"+n , "password"+n , new Date(System.currentTimeMillis()));
        userMapper.insert(user);
    }

    @Test
    public void testfindById(){
        int n = 1;
        User user = userMapper.findById(n);
        System.out.println(user);
    }

    @Test
    public void testfindByUserName(){
        int n = 1;
        List<User> list = userMapper.findByUserName("username"+n);
        System.out.println(list);
    }

    @Test
    public void testfindAll(){
        List<User> list = userMapper.findAll();
        System.out.println(list);
    }


    @Test
    public void testupdateById(){

        int n = 1;
        User user = new User(n,n +"" , "username"+n , "password_new"+n , new Date(System.currentTimeMillis()));
        userMapper.updateById(user);
    }


    // 主键删除
    @Test
    public void testdelete(){
        int n = 1;
        User user = new User(n,n +"" , "username"+n , "password_new"+n , new Date(System.currentTimeMillis()));
        userMapper.delete(user);
    }

    @Test
    public void testdeleteById(){
        int n = 1;
        userMapper.deleteById(n);
    }


    @Test
    public void testdeleteByIds(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        userMapper.deleteByIds(list);
    }

}
