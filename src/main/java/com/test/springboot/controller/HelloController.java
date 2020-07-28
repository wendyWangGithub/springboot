package com.test.springboot.controller;

import com.test.springboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.Calendar;
import java.util.List;

//@Controller
@RestController//工厂扫描到@RestController就会对HelloController创建一个实例
@RequestMapping("hello")
public class HelloController {

    @Value("${name}")//通过工厂去管理name，给name注入值，基本属性注入值。
    private String name;
    @Value("${server.port}")//想把port
    private String port;//port类型也可以定义为int
    //因为helloServiceImpl已经注册到当前工厂中，所以可以在HelloController类的任意位置进行HelloService的注入
    @Value("${age}")
    private Integer age;
    @Value("${price}")
    private double price;
    @Value("${qqs}")
    private String[] qqs;
    @Autowired
    private HelloService helloService;
    @Autowired
    private Calendar calendar;
    @Autowired
    private Connection connection;
    @Autowired
    private Connection connection1;

    public HelloController() {
    }

    /**springboot修改内置tomcat的端口 https://www.cnblogs.com/bigxuan/p/11194052.html
     *访问控制器的路径： localhost：8081/项目名/hello/hello，但是springboot的应用默认是没有项目名的
     * http://localhost:8081/hello/hello，因为没有设置项目名，所以直接写hello就可以
     * @return
     */
    @RequestMapping("hello")
    //@ResponseBody //将Controller返回的Java对象自动转换成json或者xml，使用springboot不需要引入maven 的json
    public String hello() {
        helloService.hello("springboot");
        System.out.println("姓名:" + name);
        System.out.println("端口:" + port);
        for(String qq:qqs) {
            System.out.println("遍历数组:" + qq);
        }
        System.out.println("calendar:" + calendar.getTime());
        System.out.println("Connection" + connection);
        //加上 @Scope("prototype")标签后变成多例模式，每次请求都会是新的对象，所以connection和connection1的值就不同了。并发时使用多例模式
        //因为是单例，所以默认注入的是同一个对象，connection和connection1打印的值完全相同。
        System.out.println("Connection1" + connection1);
        String helloSpringBoot = "hello spring boot";
        String aa = JSON.toJSONString(helloSpringBoot, true);
        return aa;
    }

    @RequestMapping("hello2")
    public String hello2() {
        String helloSpringBoot = "hello spring boot";
        String aa = JSON.toJSONString(helloSpringBoot, true);
        return aa;
    }

    @RequestMapping("hello3")//http://localhost:9090/ems/hello/hello3
    public String hello3() {
        String helloSpringBoot = "hello spring boot";
        String aa = JSON.toJSONString(helloSpringBoot, true);
        return aa;
    }
}
