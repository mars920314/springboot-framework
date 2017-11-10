package com.datayes.framework.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements BaseJob {
	
	public HelloJob(){
		
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("test schedule job");
	}

}
