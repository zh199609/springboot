package com.zl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.zl.entity.Employee;
import com.zl.mapper.EmployeeMapper;

@CacheConfig(cacheNames = "emp")//类指定缓存配置
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    // 将方法的运行结果进行缓存；

    /**
     * CacheMannager管理多个Cache组件，对缓存的真正CRUD操作在Cache组件中，每个缓存组件有自己唯一一个名字
     * 几个属性：
     * cacheNames/value:指定缓存组件的名字；
     * key:缓存数据的key 默认使用方法参数的值 编写spel表达式
     * keyGenerator:key的生成器，可以自己指定key的生成器的组件id key和keyGenerator二选一
     * cacheManager:指定缓存管理器
     * condition：指定符合条件的情况下才缓存
     * unless:否定缓存 当unless指定的条件为true  不缓存 可以获取到结果进行判断 #result == null
     * sync:是否使用异步模式
     * <p>
     * 如果设置sync=true，
     * 如果缓存中没有数据，多个线程同时访问这个方法，则只有一个方法会执行到方法，其它方法需要等待
     * 如果缓存中已经有数据，则多个线程可以同时从缓存中获取数据
     *
     * @param id
     * @return 原理： 1.自动配置类:CacheAutoConfiguration 多个缓存配置类 2.哪个配置类生效
     * SimpleCacheConfiguration->给容器中注册了一个CacheManager   ConcurrentMapCacheManager
     * 3.
     */


    @Cacheable(value = "emp", cacheManager = "cacheManager")
    public Employee getEmpById(Integer id) {
        System.err.println("查询：" + id + "号员工");
        return employeeMapper.getEmpById(id);
        //
    }

    @Cacheable(cacheNames = "emp", keyGenerator = "myKeyGenerator", condition = "#id > 1")
    public Employee getEmpById2(Integer id) {
        System.err.println("查询：" + id + "号员工");
        return employeeMapper.getEmpById(id);
        //myKeyGenerator
    }

    /*
     * @CachePut:即调用方法，又更新缓存
     * 	运行时机：
     * 		1.先调用目标方法
     * 		2.把方法返回的结果缓存
     *
     */
    @CachePut(value = "emp", key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        System.err.println("updateEmp" + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }


    /**
     * @CacheEvit
     */
    @CacheEvict(cacheNames = "emp", key = "#id")
    public void deleteEmp(Integer id) {
        System.err.println("删除员工：" + id);
        //employeeMapper.deleteEmpById(id);
    }

    /**
     * @return
     * @Caching
     */
    @Caching(
            cacheable = {
                    @Cacheable(value = "emp", key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp", key = "#result.id"),
                    @CachePut(value = "emp", key = "#result.email")
            }

    )
    public Employee getEmpByLastName(String name) {
        return employeeMapper.getEmpByLasyName(name);
    }

}
