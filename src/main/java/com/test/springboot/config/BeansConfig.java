package com.test.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

//一次性在工厂中批量创建多个对象，用@Configuration就表示这是一个配置类
//@Component，也可以用@Component注释，功能和@Configuration是一样的，但是语义不同，@Configuration是springboot的全新注解，是配置，要配置多个对象。
//@Component是用来创建单个对象，效率没有@Configuration效率高，因为@Component是要扫描后才构建组件实例，@Configuration在springboot底部，无需扫描，他是一个配置注解，不会去扫描
//直接把加入@Configuration的类，以类对象的方式，拿到类的信息。

@Configuration//工厂配置文件，配置注解
public class BeansConfig {

    //工厂中每一个方法代表一个对象的创建Calendar
    //注解 修饰范围用在方法上相当于spring.xml文件中的bean标签作用，用来创建这个对象在工厂一个实例
    //Bean把Canlenar对象在工厂中创建处理。
    @Bean
    public Calendar getCalender() {
        return  Calendar.getInstance();
    }

    @Bean//为了交给工厂管理要加上@Bean
    @Scope("prototype")//工厂在构建对象时，基于多例的模式去构建，每次请求，拿一个新的对象。在工厂中使用一次，就要去拿一个对象。并发时使用多例模式
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Hongkong","root","123456");
        return connection;
    }
}
