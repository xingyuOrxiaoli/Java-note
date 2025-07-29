package com.xiaoli;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.xiaoli.mapper")
@SpringBootApplication
@ServletComponentScan
public class XiaoLiApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(XiaoLiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(XiaoLiApplication.class , args);
    }
}
