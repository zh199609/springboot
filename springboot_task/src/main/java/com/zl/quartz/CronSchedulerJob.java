package com.zl.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CronSchedulerJob {


    public void scheduleJob1(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class).withIdentity("job1", "group1")
                .build();
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/6 * * * * ?");

        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").usingJobData("name", "sadgaioushd")
                .withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    public void scheduleJobs() throws SchedulerException, InterruptedException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduleJob1(scheduler);
        /*ScheduledJob jobInstance = (ScheduledJob) currentlyExecutingJobs.get(0).getJobInstance();
        jobInstance.setName("修改的值");*/

    }
}
