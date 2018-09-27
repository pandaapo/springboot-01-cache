package com.atguigu.cache.service;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * CacheManager管理多个Cache组件，对缓存的CRUD操作在Cache组件中进行，每一个缓存组件有自己唯一的名字
     * @Cacheable的几个属性
     *  cacheNames/value：指定缓存组件的名字
     *  key：缓存数据使用的key；默认是使用方法参数的值；
     *      支持SpEL表达式：#id（参数id的值） #a0 #p0 #root.args[0]
     *      ？？？疑问：上面的#a0 #p0是什么意思？
     *  keyGenerator：key的生成器；可以自定义该生成器；key/keyGenerator二选一
     *  cacheManager（指定缓存管理器）和cacheResolver（指定缓存解析器），功能类似
     *  condition：指定符合条件的情况下才缓存；支持SpEL表达式
     *  unless：否定缓存；当unless指定的条件为true，方法的返回值不会被缓存；可以获取到结果进行判断，如unless="#result == null"
     *  sync：是否使用异步模式
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmp(Integer id){
//        查询员工
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }
}
