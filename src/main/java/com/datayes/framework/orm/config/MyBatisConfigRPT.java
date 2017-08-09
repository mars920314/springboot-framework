package com.datayes.framework.orm.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Repository;

@Repository
@Configuration
// 扫描mybatis的接口
@MapperScan(basePackageClasses = com.datayes.framework.orm.dao.model.rpt.RPTMapper.class, sqlSessionTemplateRef = "SqlSessionTemplateRPT")
//因为这个对象的扫描，需要在DataSourceFactory的后面注入，所以加上下面的注解
//@AutoConfigureAfter(DataSourceFactory.class)
public class MyBatisConfigRPT {
	
	@Autowired
	@Qualifier("DataSourceRPT")
	private DataSource dataSource;

	@Bean(name = "SqlSessionFactoryRPT")
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setTypeAliasesPackage("tk.mybatis.springboot.model");
		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources("classpath:mybatis/mybatis-mapper-rpt-parse.xml"));
		return bean.getObject();
	}

	@Bean(name = "SqlSessionTemplateRPT")
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
