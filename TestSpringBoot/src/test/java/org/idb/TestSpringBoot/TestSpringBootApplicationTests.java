package org.idb.TestSpringBoot;

import org.idb.TestSpringBoot.entity.AppUserRole;
import org.idb.TestSpringBoot.entity.Employee;
import org.idb.TestSpringBoot.entity.User;
import org.idb.TestSpringBoot.repository.IUserRepo;
import org.idb.TestSpringBoot.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class TestSpringBootApplicationTests {

	@Autowired
	EmployeeService service;

	@Autowired
	IUserRepo repo;

	@Test
	void testUserSave(){
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodePass=encoder.encode("1234");

		User user=new User("rana@gmail.com", encodePass,"Emran", "Hossain", AppUserRole.USER);
		user.setEnable(true);
		user.setLoocked(false);
		repo.save(user);
	}

	@Test
	void testEmpSave(){
		Employee e=new Employee();
		e.setEAddress("Dhaka");
		e.setEEmail("dhaka@gmail.com");
		e.setEGender("Male");
		e.setEName("Jahid");
		service.saveEmp(e);

	}


	@Test
	void TestDelEmp(){
		service.deleteEmp(1);
	}

	@Test
	void TestListEmp(){
	Employee e=service.findEmpById(2);
		e.setEName("pp");
		service.saveEmp(e);
		System.out.println(e);
	}



}
