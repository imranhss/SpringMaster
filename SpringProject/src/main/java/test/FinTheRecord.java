package test;

import org.idb.config.SpringRootConfig;
import org.idb.dao.UserDaoImpl;
import org.idb.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FinTheRecord {
	
	
	public static void main(String args[] ) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDaoImpl daoImpl=ctx.getBean(UserDaoImpl.class);
		User u= daoImpl.findById(1);
		
		System.out.println(u.getName());
		System.out.println(u.getPhone());
	
	}
	
	
}
