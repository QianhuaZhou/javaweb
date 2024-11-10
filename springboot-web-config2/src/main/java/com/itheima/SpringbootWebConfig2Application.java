package com.itheima;

import com.example.EnableHeaderConfig;
import com.example.HeaderConfig;
import com.example.MyImportSelector;
import com.example.TokenParser;
import org.dom4j.io.SAXReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


//@ComponentScan({"com.example", "com.itheima"})
//@Import({TokenParser.class})//导入普通类,交给IOC容器管理
//@Import({HeaderConfig.class})//导入配置类, 交给IOC容器管理
//@Import({MyImportSelector.class})
@EnableHeaderConfig
@SpringBootApplication
public class SpringbootWebConfig2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebConfig2Application.class, args);
    }

    //声明第三方Bean
    /*@Bean//将当前方法的返回值对象交给IOC容器管理,成为IOC容器Bean
    public SAXReader saxReader(){
        return new SAXReader();
    }*/
}
