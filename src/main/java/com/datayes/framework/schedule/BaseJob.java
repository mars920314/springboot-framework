package com.datayes.framework.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

public interface BaseJob extends Job{

	@Override
    public void execute(JobExecutionContext context) throws JobExecutionException;
    
}
