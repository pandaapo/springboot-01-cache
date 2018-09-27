package com.atguigu.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 一搭建基本环境
 * 1、导入数据库文件，创建department和employee表
 * 2、创建javabean封装数据
 * 3、整合MyBatis操作数据库
 *  3-1、配置数据源
 *  3-2、使用注解版mybatis
 *      3-2-1、@MapperScan指定需要扫描的mapper接口所在的包
 * 二、整合缓存
 * 步骤
 * 1、开启基于注解的缓存
 * 2、标注缓存注解即可。@CacheEnable @CacheEvict @……
 */
//指定需要扫描的mapper接口所在的包
@MapperScan("com.atguigu.cache.mapper")
@SpringBootApplication
//开启基于注解的缓存
@EnableCaching
public class Springboot01CacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot01CacheApplication.class, args);
    }
}
