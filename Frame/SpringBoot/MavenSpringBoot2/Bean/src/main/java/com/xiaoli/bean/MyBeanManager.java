package com.xiaoli.bean;

import com.xiaoli.pojo.User;
import com.xiaoli.pojo.User2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanManager {


    @Bean("u1")
    public User get1User() {
        User user = new User();
        user.setId(1);
        return user;
    }
    @Bean("u2")
    public User get2User() {
        User user = new User();
        user.setId(2);
        user.setName("name2");
        return user;
    }
    @Bean("user2_1")
    public User2 get1User2(User u2) {
        User2 user2 = new User2();
        user2.setId(1);
        user2.setName("name1");
        user2.setAge(20);
        user2.setUser(u2);

        return user2;
    }
}
