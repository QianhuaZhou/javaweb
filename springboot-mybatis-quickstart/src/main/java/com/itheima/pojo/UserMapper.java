package com.itheima.pojo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper//在运行试,框架会自动生成该接口的实现类对象(代理对象),冰洁将改对象交给IOC容器管理
public interface UserMapper {
    //查询全部拥护信息
    @Select("select * from user")
    public List<User> list();
}
