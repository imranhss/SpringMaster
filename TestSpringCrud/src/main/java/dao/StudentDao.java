package dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import antlr.collections.List;
import entity.Student;

public class StudentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void create(Student s) {

		hibernateTemplate.save(s);
	}

	public java.util.List<Student> getAll() {

		java.util.List<Student> list = hibernateTemplate.loadAll(Student.class);

		return list;

	}

	public void delete(int id) {

		Student s = hibernateTemplate.load(Student.class, id);

		hibernateTemplate.delete(s);

	}

	public Student getById(int id) {

		return hibernateTemplate.get(Student.class, id);

	}
	
	

}
