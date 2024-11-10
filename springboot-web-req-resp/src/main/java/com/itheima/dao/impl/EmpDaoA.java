package com.itheima.dao.impl;

import com.itheima.dao.EmpDao;
import com.itheima.pojo.Emp;
import com.itheima.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@Component//将当前类交给IOC容器管理,成为IOC容器中的Bean(控制反转)
@Repository("daoA")//不指定:bean默认名字为类名首字母小写(一般不用指定)
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        //1.加载并解释emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();//获取xml在本地的万战路径
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
