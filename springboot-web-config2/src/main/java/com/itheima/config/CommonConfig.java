package com.itheima.config;

import com.itheima.service.DeptService;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//配置类
public class CommonConfig {
    @Bean//将当前方法的返回值对象交给IOC容器管理,成为IOC容器Bean
    //通过@Bean注解的name/value属性指定Bean名称,若未指定默认为方法名
    public SAXReader reader(DeptService deptService) {
        System.out.println(deptService);
        return new SAXReader();
    }
}
