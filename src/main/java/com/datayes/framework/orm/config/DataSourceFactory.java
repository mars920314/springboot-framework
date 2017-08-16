package com.datayes.framework.orm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@Configuration
@PropertySource("classpath:database.properties")
public class DataSourceFactory {

	@Value("${environment}")
	String env;
	
	@Bean(name="env")
	public String getEnv(){
		return env;
	}

//	@Bean(name = "DataSourceNews")
//	@Primary
//	@ConfigurationProperties(prefix = "news.dev.jdbc")
//	public DataSource DataSourceNews() {
//		return DataSourceBuilder.create().build();
//	}
//
//	@Bean(name = "DataSourceBigdata")
//	@ConfigurationProperties(prefix = "bigdata.dev.jdbc")
//	public DataSource DataSourceBigdata() {
//		return DataSourceBuilder.create().build();
//	}
//
//	@Bean(name = "DataSourceDatayesdb")
//	@ConfigurationProperties(prefix = "datayesdb.dev.jdbc")
//	public DataSource DataSourceDatayesdb() {
//		return DataSourceBuilder.create().build();
//	}
//
//	@Bean(name = "DataSourceRPT")
//	@ConfigurationProperties(prefix = "rpt.dev.jdbc")
//	public DataSource DataSourceRPT() {
//		return DataSourceBuilder.create().build();
//	}
//
//	@Bean(name = "DataSourceJYdb")
//	@ConfigurationProperties(prefix = "jydb.dev.jdbc")
//	public DataSource DataSourceJYdb() {
//		return DataSourceBuilder.create().build();
//	}
//
//	@Bean(name = "DataSourceZYYX")
//	@ConfigurationProperties(prefix = "zyyx.dev.jdbc")
//	public DataSource DataSourceZYYX() {
//		return DataSourceBuilder.create().build();
//	}

	@Bean(name = "DataSourceNews")
	@Primary
	@ConditionalOnExpression("'${environment}'=='dev'")
	@ConfigurationProperties(prefix = "news.dev.jdbc")
	public DataSource DataSourceNewsDev() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceNews")
	@ConditionalOnExpression("'${environment}'=='stg'")
	@ConfigurationProperties(prefix = "news.stg.jdbc")
	public DataSource DataSourceNewsStg() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceNews")
	@ConditionalOnExpression("'${environment}'=='prd'")
	@ConfigurationProperties(prefix = "news.prd.jdbc")
	public DataSource DataSourceNewsPrd() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceBigdata")
	@ConditionalOnExpression("'${environment}'=='dev'")
	@ConfigurationProperties(prefix = "bigdata.dev.jdbc")
	public DataSource DataSourceBigdataDev() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceBigdata")
	@ConditionalOnExpression("'${environment}'=='stg'")
	@ConfigurationProperties(prefix = "bigdata.stg.jdbc")
	public DataSource DataSourceBigdataStg() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceBigdata")
	@ConditionalOnExpression("'${environment}'=='prd'")
	@ConfigurationProperties(prefix = "bigdata.prd.jdbc")
	public DataSource DataSourceBigdataPrd() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceDatayesdb")
	@ConditionalOnExpression("'${environment}'=='dev'")
	@ConfigurationProperties(prefix = "datayesdb.dev.jdbc")
	public DataSource DataSourceDatayesdbDev() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceDatayesdb")
	@ConditionalOnExpression("'${environment}'=='stg'")
	@ConfigurationProperties(prefix = "datayesdb.stg.jdbc")
	public DataSource DataSourceDatayesdbStg() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceDatayesdb")
	@ConditionalOnExpression("'${environment}'=='prd'")
	@ConfigurationProperties(prefix = "datayesdb.prd.jdbc")
	public DataSource DataSourceDatayesdbPrd() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceRPT")
	@ConditionalOnExpression("'${environment}'=='dev'")
	@ConfigurationProperties(prefix = "rpt.dev.jdbc")
	public DataSource DataSourceRPTDev() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceRPT")
	@ConditionalOnExpression("'${environment}'=='stg'")
	@ConfigurationProperties(prefix = "rpt.stg.jdbc")
	public DataSource DataSourceRPTStg() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceRPT")
	@ConditionalOnExpression("'${environment}'=='prd'")
	@ConfigurationProperties(prefix = "rpt.prd.jdbc")
	public DataSource DataSourceRPTPrd() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceJYdb")
	@ConditionalOnExpression("'${environment}'=='dev'")
	@ConfigurationProperties(prefix = "jydb.dev.jdbc")
	public DataSource DataSourceJYdbDev() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceJYdb")
	@ConditionalOnExpression("'${environment}'=='stg'")
	@ConfigurationProperties(prefix = "jydb.stg.jdbc")
	public DataSource DataSourceJYdbStg() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceJYdb")
	@ConditionalOnExpression("'${environment}'=='prd'")
	@ConfigurationProperties(prefix = "jydb.prd.jdbc")
	public DataSource DataSourceJYdbPrd() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceZYYX")
	@ConditionalOnExpression("'${environment}'=='dev'")
	@ConfigurationProperties(prefix = "zyyx.dev.jdbc")
	public DataSource DataSourceZYYXDev() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceZYYX")
	@ConditionalOnExpression("'${environment}'=='stg'")
	@ConfigurationProperties(prefix = "zyyx.stg.jdbc")
	public DataSource DataSourceZYYXStg() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DataSourceZYYX")
	@ConditionalOnExpression("'${environment}'=='prd'")
	@ConfigurationProperties(prefix = "zyyx.prd.jdbc")
	public DataSource DataSourceZYYXPrd() {
		return DataSourceBuilder.create().build();
	}

}