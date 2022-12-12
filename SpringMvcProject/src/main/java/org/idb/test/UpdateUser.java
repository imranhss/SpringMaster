package org.idb.test;

import org.idb.config.SpringRootConfig;
import org.idb.dao.IUserDao;
import org.idb.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UpdateUser {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);

		IUserDao dao = ctx.getBean(IUserDao.class);
		
		User u = dao.findById(2);
		
		u.setName("Monu Sing");
		dao.update(u);
		

	}

}
