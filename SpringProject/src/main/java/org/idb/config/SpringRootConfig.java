package org.idb.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.idb.dao","org.idb.service", "org.idb"})
public class SpringRootConfig {

	@Bean
	public BasicDataSource getDataSource() {
		
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3307/springproject");
		ds.setUsername("root");
		ds.setPassword("1234");
		ds.setMaxTotal(2);
		ds.setInitialSize(1);
		ds.setTestOnBorrow(true);
		ds.setValidationQuery("select 1");
		ds.setDefaultAutoCommit(true);
		
		return ds;
	} 
}
