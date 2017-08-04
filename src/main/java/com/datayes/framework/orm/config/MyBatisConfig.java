package com.datayes.framework.orm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Repository
@Configuration
//支持注解事务
@EnableTransactionManagement
@AutoConfigureAfter(DataSourceFactory.class)
public class MyBatisConfig implements TransactionManagementConfigurer {

	@Autowired
	@Qualifier("DataSourceNews")
	private DataSource dataSourceNews;
	
	@Autowired
	@Qualifier("DataSourceBigdata")
	private DataSource dataSourceBigdata;
	
	@Autowired
	@Qualifier("DataSourceDatayesdb")
	private DataSource dataSourceDatayesdb;
	
	@Autowired
	@Qualifier("DataSourceJYdb")
	private DataSource dataSourceJYdb;

	@Bean(name = "TransactionManager")
	@Primary
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
        DataSourceTransactionManager dtmNews = new DataSourceTransactionManager(dataSourceNews);  
        DataSourceTransactionManager dtmBigdata = new DataSourceTransactionManager(dataSourceBigdata);
        DataSourceTransactionManager dtmDatayesdb = new DataSourceTransactionManager(dataSourceDatayesdb);  
        DataSourceTransactionManager dtmJYdb = new DataSourceTransactionManager(dataSourceJYdb);
        ChainedTransactionManager ctm = new ChainedTransactionManager(dtmNews, dtmBigdata, dtmDatayesdb, dtmJYdb);
		return ctm;
	}
}
