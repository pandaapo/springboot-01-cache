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
 * 2、标注缓存注解即可。@CacheEnable @CacheEvict @CachePut
 *
 * 默认使用的是ConcurrentMapCacheManager==ConcurrentMapCache；将数据保存在ConcurrentMap<Object,Object>中
 * 开发中使用缓存中间件：redis、memcached、ehcache
 * 三、整合redis作为缓存（尚硅谷有专门的redis课程）
 * 1、使用docker安装redis。（docker中国，比直接docker hub要快）
 * 1-1、下载镜像：docker pull registry.docker-cn.com/library/redis
 * 1-2、启动镜像：docker run -d -p 6379:6379 --name myredis registry.docker-cn.com/library/redis （-d：后台启动； -p：将容器端口和镜像端口映射；--name：取个容器名称 用哪个镜像启动）
 * 2、redis的部分常用命令：
 *     append key value
 *     get key
 *     lpush key value1 value2 value3
 *     lpop key
 *     sadd key value1 value2 value3
 *     smembers key
 *     sismember key value
 * 3、引入redis的starter
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
