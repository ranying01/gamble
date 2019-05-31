package com.ranying;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.ranying.dao")
public class GambleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GambleApplication.class);
    }

}
