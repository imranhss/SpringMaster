package org.idb.test;

import java.util.List;

import org.idb.config.SpringRootConfig;
import org.idb.dao.IUserDao;
import org.idb.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestGetAllUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);

		IUserDao dao = ctx.getBean(IUserDao.class);

		List<User> users = dao.findAll();

		for (User u : users) {
			
			System.out.println(u.getName());
			System.out.println(u.getPhone());

		}

	}

}
