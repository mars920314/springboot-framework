package com.datayes.framework.schedule;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class ScheduleTaskSampleQuartz {

	public void test(){
		JobDetail job = JobBuilder.newJob(HelloJob.class)
				.withIdentity("dummyJobName", "group1")
				.build();

		//每2小时执行一次，次数为10次
		Trigger triggerSimple = TriggerBuilder
				.newTrigger()
				.withIdentity("TriggerSimple", "group1")
				.withSchedule(SimpleScheduleBuilder.repeatHourlyForTotalCount(10, 2))
				.build();
		
		//在每5秒运行作业
		Trigger triggerCron = TriggerBuilder
				.newTrigger()
				.withIdentity("TriggerCron", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
				.build();
		
		Scheduler scheduler;
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
	    	scheduler.start();
	    	scheduler.scheduleJob(job, triggerCron);
	    	scheduler.scheduleJob(job, triggerSimple);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
