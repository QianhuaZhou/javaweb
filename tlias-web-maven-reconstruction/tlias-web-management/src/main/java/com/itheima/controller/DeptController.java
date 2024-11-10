package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    //定义日志记录对象
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);//加上@Slf4j后能直接用log

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门数据
     * @return
     */
    //@RequestMapping(value = "/depts", method = RequestMethod.GET)//指定请求方式为GET
    @GetMapping//上行的简化版本
    public Result list(){
        log.info("查询全部部门数据");//记录日志
        //调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     */
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("根据id删除部门:{}", id);//{}参数占位符
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @return
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){//封装json到Dept对象
        log.info("新增部门:{}", dept);
        deptService.add(dept);
        return Result.success();

    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("根据id查询部门:{}", id);
        Dept dept = deptService.get(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){//自动映射
        log.info("根据id编辑部门:{}", dept);
        deptService.update(dept);
        return Result.success();
    }

}
