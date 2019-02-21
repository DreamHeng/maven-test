package com.dreamheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootApplication
@MapperScan("com.dreamheng.dao")
public class AppRun {
    public static void main(String[] args) {
        SpringApplication.run(AppRun.class,args);
    }

}
