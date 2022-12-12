package org.idb.test;

import java.util.List;

import org.idb.config.SpringRootConfig;
import org.idb.dao.IUserDao;
import org.idb.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAddUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);

		IUserDao dao = ctx.getBean(IUserDao.class);

		User u=new User();
		
		u.setName("Apple");
		u.setAddress("Dhaka");
		u.setEmail("applez2gmail.com");
		u.setLoginName("apple");
		u.setPassword("1234");
		u.setPhone("852963");
		u.setRole(1);
		u.setUserStatus(1);
		
		dao.save(u);
		System.out.println("save");

	}

}
