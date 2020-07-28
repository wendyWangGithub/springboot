package com.test.springboot.service;

import org.springframework.stereotype.Service;

@Service
/**业务层组件，在启动应用时，因为入口类有@EnableAutoConfiguration注解，会读入口类
 *根据 @ComponentScan会找入口类所在的包及子包。扫描到@Service注解时，会把
 * HelloServiceImpl对象注册到现有工厂。
**/
public class HelloServiceImpl implements HelloService{

    @Override
    public void hello(String name) {
        System.out.println("hello service：" + name);
    }
}
