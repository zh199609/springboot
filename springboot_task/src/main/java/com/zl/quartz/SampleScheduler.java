package com.zl.quartz;

import com.zl.service.MyService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class SampleScheduler {

    @Autowired
    private MyService myService;


    @Bean
    public JobDetail myJobDetail() {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("myService", myService);
        return JobBuilder.newJob(MyJob.class).withIdentity("sampleJob")
                .usingJobData(jobDataMap).storeDurably().build();
    }

    @Bean
    public Trigger myTrigger() {
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2).repeatForever();
        return TriggerBuilder.newTrigger().forJob(myJobDetail()).withIdentity("sampleJob").withSchedule(simpleScheduleBuilder).build();
    }



}

