package test;

import java.util.List;

import org.idb.config.SpringRootConfig;
import org.idb.dao.IUserDao;
import org.idb.dao.UserDaoImpl;
import org.idb.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AddUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		IUserDao  userDao=ctx.getBean(IUserDao.class);

		User u=new User();
		
		u.setName("Apple");
		u.setAddress("Dhaka");
		u.setEmail("applez2gmail.com");
		u.setLoginName("apple");
		u.setPassword("1234");
		u.setPhone("852963");
		u.setRole(1);
		u.setLoginStatus(1);
		
		userDao.save(u);
		System.out.println("save");
		
	}

}
