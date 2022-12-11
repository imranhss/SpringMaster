package org.idb.test;

import javax.sql.DataSource;

import org.idb.config.SpringRootConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		DataSource ds=	ctx.getBean(DataSource.class);
		
		JdbcTemplate jt=new JdbcTemplate(ds);
		
		String sql="insert into user(name,phone, address,loginName,password) values(?,?,?,?,?)";

		String val[]= {"emran","123456789", "dhaka", "emranhss","1234"};

		jt.update(sql, val);
		System.out.println("Done");
	
		
		

	}

}
