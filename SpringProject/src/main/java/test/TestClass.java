/**
 * 
 */
package test;



import javax.sql.DataSource;

import org.idb.config.SpringRootConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author imran
 *
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		javax.sql.DataSource ds=ctx.getBean(DataSource.class);
		JdbcTemplate jt=new JdbcTemplate(ds);
		String jdbc=" insert into user(name,phone, address,loginName,password) values(?,?,?,?,?)";
		
		Object[] obj=new Object[] {
				"emran","123456789", "dhaka", "emranhss","1234" 
		};	
		
		jt.update(jdbc, obj);
		System.out.println("Done");
		
	}
}	
