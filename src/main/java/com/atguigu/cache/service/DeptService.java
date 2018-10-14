package com.atguigu.cache.service;

import com.atguigu.cache.bean.Department;
import com.atguigu.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@Service
public class DeptService {
    @Autowired
    DepartmentMapper departmentMapper;

    //表示使用id为deptCacheManager的缓存管理器，即方法名
    @Qualifier("deptCacheManager")
    @Autowired
    RedisCacheManager deptCacheManager;

    /**
     * 缓存的数据能存入redis，但是第二次从缓存中查询就不能反序列化：因为我们保存dept默认是json数据使。CacheManager默认使用RedisTemplate<Object, Employee>操作redis的。
     * @param id
     * @return
     */
//    @Cacheable(cacheNames = "dept",cacheManager = "deptCacheManager")
//    public Department getDeptById(Integer id){
//        Department department = departmentMapper.getDeptById(id);
//        return department;
//    };

//    通过编码实现redis缓存方法：使用缓存管理器得到缓存，进行api调用
    public Department getDeptById(Integer id){
        Department department = departmentMapper.getDeptById(id);
        //获取某个缓存
       Cache dept = deptCacheManager.getCache("dept");
        dept.put("dept:1", department);
        return department;
    };
}
