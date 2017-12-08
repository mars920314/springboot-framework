package com.datayes.framework.schedule.factory;

import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ParseException;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.datayes.framework.schedule.HelloJob;

//@Configuration
public class ScheduledConfiguration {

    /** 
     * attention: 
     * Details：配置定时任务 
     * 此工厂主要用来制作一个jobDetail，即制作一个任务。由于我们所做的定时任务根本上讲其实就是执行一个方法。所以用这个工厂比较方便。
     * ScheduleTask为需要执行的任务  
     */  
    @Bean(name = "jobDetailBean")  
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(HelloJob helloJob) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        /* 
         *  是否并发执行 
         *  对于相同的JobDetail，当指定多个Trigger时, 很可能第一个job完成之前，第二个job就开始了。指定concurrent设为false，多个job不会并发运行，第二个job将不会在第一个job完成之前开始。
         *  例如每5s执行一次任务，但是当前任务还没有执行完，就已经过了5s了。 如果此处为true，则下一个任务会执行，如果此处为false，则下一个任务会等待上一个任务执行完后，再开始执行 
         */  
        jobDetail.setConcurrent(false);
        
        /*
         * 设置任务的名字  
         * 设置任务的分组，这些属性都可以存储在数据库中，在多任务的时候使用  
         */
        jobDetail.setName("srd-chhliu");
        jobDetail.setGroup("srd");
        
        /* 
         * 为需要执行的实体类对应的对象 
         */  
        jobDetail.setTargetObject(helloJob);  
          
        /* 
         * 指定需要定时执行scheduleInfoAction中的simpleJobTest()方法
         * sayHello为需要执行的方法。通过这几个配置，告诉JobDetailFactoryBean我们需要执行定时执行ScheduleTask类中的sayHello方法 
         */  
        jobDetail.setTargetMethod("");  
        return jobDetail;  
    }

    /** 
     * attention: 
     * Details：配置定时任务的触发器，也就是什么时候触发执行定时任务 
     */  
    @Bean(name = "cronTriggerBean")  
    public CronTriggerFactoryBean cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetailBean) {  
		CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();  
		tigger.setJobDetail(jobDetailBean.getObject());
		/*
		 * 初始时的cron表达式
		 * 每天20:30执行
		 */
		try {
		    tigger.setCronExpression ("0 30 20 * * ?");
		} catch (ParseException e) {
		    e.printStackTrace ();
		}
		/*
		* 设置trigger的名字
		*/
		tigger.setName("srd-chhliu");
		return tigger;  
  
    }

    /** 
     * attention: 
     * Details：定义quartz调度工厂 
     * 主要的管理的工厂，这是最主要的一个bean。quartz通过这个工厂来进行对各触发器的管理。
     */  
    @Bean(name = "schedulerBean")  
    public SchedulerFactoryBean schedulerFactory(Trigger[] cronJobTrigger) {  
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();  
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job  
        scheduler.setOverwriteExistingJobs(true);  
        // 延时启动，应用启动1秒后  
        scheduler.setStartupDelay(1);
        // 注册触发器  
        scheduler.setTriggers(cronJobTrigger);  
        return scheduler;  
    } 
}
