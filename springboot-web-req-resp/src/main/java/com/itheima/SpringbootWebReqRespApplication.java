package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//@ComponentScan({"com.itheima.dao", "com.itheima"})//若dao与当前程序不同级,不推荐
@SpringBootApplication
public class SpringbootWebReqRespApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebReqRespApplication.class, args);
	}

}
