package com.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringbootApplication注解代表这是一个springboot入口类，这个注解只能出现一次
 * 相当于以下三个注解
 * @SpringBootConfiguration
 * @EnableAutoConfiguration
 * @ComponentScan
 */
@SpringBootApplication
public class StartApplication {

    public static void main(String[] args) {
        //启动springboot应用
        //参数1：入口类类对象，参数2：main函数参数
        SpringApplication.run(StartApplication.class, args);
    }
}
