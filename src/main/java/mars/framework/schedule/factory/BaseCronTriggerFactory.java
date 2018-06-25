package mars.framework.schedule.factory;

import java.io.Serializable;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.expression.ParseException;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

public abstract class BaseCronTriggerFactory extends CronTriggerFactoryBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
    public void init(){
        // 得到任务
        JobDetail jobdetail = JobBuilder.newJob(this.getMyTargetObject().getClass()).withIdentity(this.getClass().getSimpleName()).build();
        this.setJobDetail(jobdetail);
        this.setName(this.getClass().getSimpleName());
        try {
            this.setCronExpression(this.getMyCronExpression());
        } catch (ParseException e) {
		    e.printStackTrace ();
		}
    }

    public abstract String getMyCronExpression();

    public abstract Job getMyTargetObject();
}
