package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Delete("delete from emp where id = #{id}")
    public int delete(Integer id);

    //属性名-驼峰命名
    @Options(useGeneratedKeys = true, keyProperty = "id")//指定返回主键值,通过id封装
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values(#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);//使用实体类将多个对象封装

    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId}, update_time = #{updateTime} where id = 1")
    public void update(Emp emp);


    //sol1: 给字段起别名,让别名与属性名一致
    /*@Select("select id, username, password, name, gender, image, job, entrydate, dept_id deptId, create_time createTime, update_time updateTime from emp where id = #{id}")
    public Emp getById(Integer id);*/

    //sol2: 通过@Results, @Result注解手动映射封装
    /*@Results({
            @Result(column = "dept_id", property = "deptId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);
*/

    //sol3:开启mybatis的驼峰明明自动映射开关(application.properties)
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);

    //条件查询员工
    /*@Select("select * from emp where name like '%${name}%' and gender = 1 and " +
            "entrydate between #{gender} and #{begin} order by #{end} desc;")//$:拼接,不预编译
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);*/

    /*@Select("select * from emp where name like concat('%', '张', '%') and gender = 1 and " +
            "entrydate between #{gender} and #{begin} order by #{end} desc;")//$:拼接,不预编译
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);*/

    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    //动态更新员工
    public void update2(Emp emp);

    //批量删除员工
    public void deleteByIds(List<Integer> ids);
}
