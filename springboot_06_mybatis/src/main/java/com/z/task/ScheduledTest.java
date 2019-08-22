package com.z.task;

import com.z.entity.Deptment;
import com.z.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ScheduledTest
 * @Description: TODO
 * @Author: zl
 * @Date: 2019/8/8 21:49
 * @Version: 1.0
 **/
@Component
@EnableScheduling
public class ScheduledTest {

    @Autowired
    private DeptMapper deptMapper;

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(5);
        return taskScheduler;
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void task1() {
        boolean runFlag = true;
        try {
            Deptment deptment = new Deptment();
            deptment.setId(17);
            deptment.setDeptmentName("喜a喜");
            deptMapper.insertDept(deptment);
            System.out.println("task1插入成功");
        } catch (Exception e) {
            runFlag = false;
            System.out.println("task1插入失败");
            //e.printStackTrace();
        }
        if (runFlag){
            System.out.println("执行业务代码");
        }
        System.out.println("task1执行完成");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void task2() {
        boolean runFlag = true;
        try {
            Deptment deptment = new Deptment();
            deptment.setId(17);
            deptment.setDeptmentName("喜b喜");
            deptMapper.insertDept(deptment);
            System.out.println("task2插入成功");
        } catch (Exception e) {
            runFlag = false;
            System.out.println("task2插入失败");
            //e.printStackTrace();
        }
        if (runFlag){
            System.out.println("执行业务代码");
        }
        System.out.println("task2执行完成");
    }
}
