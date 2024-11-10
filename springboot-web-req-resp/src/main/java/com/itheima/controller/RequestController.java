package com.itheima.controller;

import com.itheima.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

//原始接受方式
/*@RestController
public class RequestController {
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request){
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");

        int age = Integer.parseInt(ageStr);
        System.out.println(name + ":" + age);
        return "OK";
    }
}*/

//springboot方式
@RestController
public class RequestController {
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name="name", required = false) String username, Integer age){
        System.out.println(username + ":" + age);
        return "OK";
    }

    //2.实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("/complexPojo")
    public String complexPojo(User user){
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "OK";
    }

    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "OK";
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id){
        System.out.println(id);
        return "OK";
    }

    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id, @PathVariable String name){
        System.out.println(id+" "+name);
        return "OK";
    }

}


