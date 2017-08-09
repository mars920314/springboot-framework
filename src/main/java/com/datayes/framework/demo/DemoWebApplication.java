package com.datayes.framework.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.datayes.framework.WebApplicationBase;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.datayes.framework"})
//@SpringBootApplication
@Order(value=1)
public class DemoWebApplication implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        WebApplicationBase.run(DemoWebApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
