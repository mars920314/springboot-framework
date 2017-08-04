package com.datayes.framework.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.datayes.framework.WebApplicationBase;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.datayes.framework"})
//@SpringBootApplication
public class DemoWebApplication {

    public static void main(String[] args) throws Exception {
        WebApplicationBase.run(DemoWebApplication.class, args);
    }

}
