package org.idb.test;

import java.util.List;

import org.idb.config.SpringRootConfig;
import org.idb.dao.IUserDao;
import org.idb.entity.User;
import org.idb.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAddUserService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);

		IUserService service = ctx.getBean(IUserService.class);

		User u=new User();
		
		u.setName("Jahid");
		u.setAddress("Gazipur");
		u.setEmail("jahid@gmail.com");
		u.setLoginName("jahidgazipuri");
		u.setPassword("1234");
		u.setPhone("01611223344");
		u.setRole(service.ROLE_USER);
		u.setUserStatus(service.LOGIN_STATUS_ACTIVE);
		
		service.userRegister(u);
		System.out.println("save");

	}

}
