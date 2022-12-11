package test;

import java.util.List;

import org.idb.config.SpringRootConfig;
import org.idb.dao.IUserDao;
import org.idb.dao.UserDaoImpl;
import org.idb.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FinAllRecord {
	
	
	public static void main(String args[] ) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		IUserDao daoImpl=ctx.getBean(IUserDao.class);

		List<User> users=daoImpl.findAll();
		
		for(User u:users) {
			System.out.println(u.getName());
			
		}
		
		
	
	}
	
	
}
