package mars.framework.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
//@EnableScheduling
public class ScheduleTaskSampleSpring {

	//每天20:30执行
//	@Scheduled(cron = "0 30 20 * * ?")
	public void test1(){
		System.out.println("test schedule 1");
	}

	//每分钟执行一次
//	@Scheduled(cron = "0 0/1 * * * ?")
	public void test2(){
		System.out.println("test schedule 2");
	}

	//每1秒执行一次
//	@Scheduled(fixedRate = 1000)
	public void test3(){
		System.out.println("test schedule 3");
	}
	
}
