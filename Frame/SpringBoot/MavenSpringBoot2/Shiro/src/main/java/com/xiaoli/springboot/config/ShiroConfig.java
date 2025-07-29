package com.xiaoli.springboot.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {


    @Bean
    public SecurityManager securityManager() {
        SecurityManager securityManager = new SecurityManager();


        return securityManager;
    }


//    @Bean
//    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
//
//        return null;
//    }

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}
