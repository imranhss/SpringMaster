package test;



import org.idb.config.SpringRootConfig;
import org.idb.entity.User;
import org.idb.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AddUserService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
//		IUserService  service=ctx.getBean(IUserService.class);
		IUserService service=ctx.getBean(IUserService.class);

		User u=new User();
		
		u.setName("Apple Service");
		u.setAddress("Dhaka");
		u.setEmail("applezservice@gmail.com");
		u.setLoginName("apple");
		u.setPassword("1234");
		u.setPhone("852963");
		u.setRole(IUserService.ROLE_ADMIN);
		u.setLoginStatus(IUserService.LOGIN_STATUS_ACTIVE);
		
		service.userRegiter(u);
		System.out.println("register");
		
	}

}
