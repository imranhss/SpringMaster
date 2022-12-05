package controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import entity.Student;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDao dao;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		List<Student> list=dao.getAll();
		
		model.addAttribute("list", list);
		
		return "home";
	}
	
	@RequestMapping("/addStudent")
	public String addStudent(Model model) {
		
		model.addAttribute("title", "Add Student");
		
		return "student_form";
	}
	
	
	@RequestMapping(value ="/save-student", method=RequestMethod.POST)
	public RedirectView saveStudent(@ModelAttribute() Student student) {
		
		System.out.println(student);
		dao.create(student);
		
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl("/");
		 return redirectView;
	}
	
	@RequestMapping("/delete-student/{id}")
	public RedirectView deleteStudent(@PathVariable("id") int id) {
		dao.delete(id);
		
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl("/");
		 return redirectView;
	}
	
	@RequestMapping("/edit-student/{id}")
	public String  updateForm(@PathVariable("id") int id, Model model) {
		
		Student s=dao.getById(id);
		model.addAttribute("student", s);
		
		return "update_form";
	}

}
