package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门数据
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据id删除部门
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增部门信息
     * @param dept
     */
    @Insert("Insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    /**
     * 查询部门信息
     * @param id
     */
    @Select("select * from dept where id = #{id}")
    Dept get(Integer id);//自动映射

    /**
     * 编辑部门信息
     * @param dept
     */
    @Update("update dept set name = #{name}, update_time=#{updateTime} where id = #{id}")
    void update(Dept dept);
}
