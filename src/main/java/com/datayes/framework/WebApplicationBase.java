package com.datayes.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Web 类型应用入口，对外提供FE接口
 */
@Configuration
@ComponentScan
public class WebApplicationBase {

    public static ConfigurableApplicationContext run(Object source, String[] args) {
        return  run(new Object[] { source }, args);
    }

    public static ConfigurableApplicationContext run(Object[] sources, String[] args) {
        List<Object> sourcesExt = new ArrayList<>(Arrays.asList(sources));
        sourcesExt.add(WebApplicationBase.class);
        SpringApplication app = new SpringApplication(sourcesExt.toArray());
        System.setProperty("rrp_web_framework.is_web_application", "true");
        return app.run(args);
    }
}
