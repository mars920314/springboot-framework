package com.datayes.framework.schedule.factory;

import java.io.Serializable;

import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.datayes.framework.schedule.HelloJob;

public class InitializingCronTrigger extends BaseCronTriggerFactory implements Serializable {

	private static final long serialVersionUID = 1L;

    @Autowired
    private SchedulerFactoryBean scheduler;
    
    public InitializingCronTrigger(){
    	init();
    }
    
	@Override
	public String getMyCronExpression() {
		return "0/5 * * * * ?";
	}

	@Override
	public Job getMyTargetObject() {
		return new HelloJob();
	}
	
	public void scheduleJob(){
		try {
			Scheduler aScheduler = scheduler.getObject();
			aScheduler.start();
			aScheduler.scheduleJob(this.getObject());
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
