package org.idb.test;

import org.idb.config.SpringRootConfig;
import org.idb.dao.IUserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DeleteUser {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);

		IUserDao dao = ctx.getBean(IUserDao.class);
		
		dao.delete(1);
		
		System.out.println("Delete Succeess");
	
	}
	

}
