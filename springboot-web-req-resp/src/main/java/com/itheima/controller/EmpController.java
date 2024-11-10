package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.service.impl.EmpServiceA;
import com.itheima.utils.XmlParserUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    //@Qualifier("empServiceB")//优先级高于@Primary,配合Autowired使用
    //@Autowired//运行时,IOC容器会提供该类型的Bean对象,并赋值给该变量(依赖注入)
    //private EmpService empService;

    @Resource(name = "empServiceB")//优先级高于@Primary,不用配合Autowired使用
    private EmpService empService;

    /*
    Interview
    @Autowired: spring框架提供,按类型注入
    @Resource: JDK提供,按名称注入
     */

    @RequestMapping("/listEmp")
    public Result list(){
        //1.调用service,获取数据
        List<Emp> empList = empService.listEmp();
        //3.响应数据
        return Result.success(empList);
    }
        /*//1.加载并解释emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();//获取xml在本地的万战路径
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        //2.对数据进行转换处理
        empList.stream().forEach(emp -> {
            //处理gender 1:男 2:女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
            }

            //处理job - 1:讲师 2:班主任 3:就业知道
            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if("2".equals(job)){
                emp.setJob("班主任");
            }else if("3".equals(job)){
                emp.setJob("就业指导");
            }
        });
        //3.响应数据
        return Result.success(empList);

    }*/
}
