package com.xiaoli.config;

import com.xiaoli.annotation.NotIncludeSwagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket getDocket() {
        Predicate<RequestHandler> customPredicate = requestHandler ->
                requestHandler.declaringClass().getPackage().getName().startsWith("com.xiaoli.controller") &&
                        !requestHandler.isAnnotatedWith(NotIncludeSwagger.class);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerDemoApiInfo())
                .select()
                .apis(customPredicate)
                .paths(allowPaths())
                .build();
    }

    private Predicate<String> allowPaths() {
        Predicate<String> p1 = regex("/my/.*");
        Predicate<String> p2 = regex("/my2/.*");
        return  p1.or(p2);
    }

    public ApiInfo swaggerDemoApiInfo() {
        return new ApiInfoBuilder()
                .contact(new Contact("小李", "http://xiaoli.com", "xiaoli@xiaoli.com"))
                .title("这是title部分")
                .description("关于描述部分")
                .version("1.0.1")
                .build();
    }
}
