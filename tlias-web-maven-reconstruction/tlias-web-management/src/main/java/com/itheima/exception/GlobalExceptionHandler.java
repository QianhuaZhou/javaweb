package com.itheima.exception;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理器
 */
@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)//捕获所以异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("操作失败,请联系管理员");
    }
}
