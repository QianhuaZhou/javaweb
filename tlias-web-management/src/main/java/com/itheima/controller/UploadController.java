package com.itheima.controller;

import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itheima.pojo.Result;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
   /* 本地存储文件
   @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {//与前端也变表单项名称一直
        log.info("文件上传: {}, {}, {}", username, age, image);

        //获取原始文件名 - 1.0.0.jpg - .jpg
        String originalFilename = image.getOriginalFilename();

        //构建唯一文件名(不重复)-UUIC(通用唯一识别码)
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新的文件名:{}", newFileName);

        //储存文件在本地
        image.transferTo(new File("/Users/evelynzhou/Documents/Code/JavaWeb/mycode/data/"+newFileName));
        return Result.success();
    }*/

    //阿里云存储文件
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {//参数名与接口文档一致
        log.info("文件上传, 文件名:{}", image.getOriginalFilename());

        //调用阿里云OSS工具类中upload方法进行文件上传
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成,文件访问url:{}", url);

        return Result.success(url);
    }
}
