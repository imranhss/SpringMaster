package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entities.ToDo;

@Controller
public class HomeController {
	
	@Autowired
	private ServletContext con;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("page", "home");
		List<ToDo> list=(List<ToDo>)con.getAttribute("list");
		model.addAttribute("todo", list);
		return "home";
	}
	
	@RequestMapping("/add")
	public String addToDo(Model model) {
		ToDo t=new ToDo();
		
		model.addAttribute("page", "add");
		model.addAttribute("todo", t);
		
		return "home";
	}
	
	
	@RequestMapping(value="/saveTodo" , method=RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo")ToDo t,Model model) {
		System.out.println(t);
		t.setDate(new Date());
		
		List<ToDo> list=(List<ToDo>)con.getAttribute("list");
		
		list.add(t);
		
		model.addAttribute("msg", "Added");
		return "home";
	}
	
	
	@RequestMapping("/bye")
	public String bye(Model model ) {
		
		model.addAttribute("message", "Hello How are you");
		return "bye";
	}

}
