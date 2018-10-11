package com.atguigu.cache;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;

    // 这个操作k-v都是字符串的redis缓存
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    // 这个操作k-v都是对象的redis缓存
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;

    /**
     * 基本的redis数据类型：String List Set Hash（三列） ZSet（有序集合）
     *  stringRedisTemplate.opsForValue();(String)
     *  stringRedisTemplate.opsForHash();（List）
     *  stringRedisTemplate.opsForSet(); (Set)
     *  stringRedisTemplate.opsForZSet() (ZSet)
    */
    @Test
    public void test01(){
        stringRedisTemplate.opsForValue().append("hello","panda");
        stringRedisTemplate.opsForValue().get("hello");
    }

    //测试保存对象
    @Test
    public void test02(){
        Employee emp = employeeMapper.getEmpById(1);
        /**
         * 如果保存的是对象，默认使用jdk序列化机制，将序列化数据保存到redis。
         */
//        redisTemplate.opsForValue().set("emp-01", emp);
        /**
         * 自定义配置，改成json数据格式序列化
         */
        empRedisTemplate.opsForValue().set("emp-01", emp);
    }

    @Test
    public void contextLoads(){
        Employee emp = employeeMapper.getEmpById(1);
        System.out.println(emp);
    }
}
