package test;



import org.idb.config.SpringRootConfig;
import org.idb.dao.IContactDao;
import org.idb.entity.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AddContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		IContactDao  userDao=ctx.getBean(IContactDao.class);

		Contact u=new Contact();
		
		u.setUserId(1);
		u.setName("JAM");
		u.setEmail("applez2gmail.com");		
		u.setPhone("852963");
		u.setRemarks("active");
		
		
		userDao.save(u);
		
		System.out.println("save");
		
	}

}
