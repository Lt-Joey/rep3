package com.turing.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.turing",excludeFilters = {
		@Filter(type=FilterType.ANNOTATION,value= {
				EnableWebMvc.class,Controller.class
		})
})
@MapperScan(basePackages = "com.turing.mapper")
@ImportResource("classpath:spring-transaction.xml")
public class RootConfig {

	// 配置数据源
	// 加入数据源
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:mysql:///car");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");

		// 连接四要素
		dataSource.setUrl("jdbc:mysql:///car");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		// 连接池的一些属性
		dataSource.setInitialSize(20);// 初始连接数
		dataSource.setMaxIdle(10);// 最大闲置数
		dataSource.setMinIdle(2);// 最小闲置数
		dataSource.setMaxTotal(50);// 最大连接数
		dataSource.setMaxWaitMillis(5000);// 最大连接等待时间

		return dataSource;
	}
	
	/**
	 * 加入SQLsessionFactory,类似于之前的Mybatis-config.xml
	 * @throws Exception 
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		//设置数据源
		bean.setDataSource(dataSource);
		return bean.getObject();		
	}
	
	//配置事务管理器
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
		
	}
	
	
}
