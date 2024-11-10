package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    /**
     * 查询全部部门数据
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    void delete(Integer id) throws Exception;

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 查询部门
     * @param id
     */
    Dept get(Integer id);

    /**
     * 编辑部门
     * @param dept
     */
    void update(Dept dept);
}
