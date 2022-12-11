package org.idb.controller;

import org.idb.entity.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping(value={"/index", "/"})
	public String index(Model m) {
		m.addAttribute("command", new UserLogin());
		
		return "index";
	} 
	
	@RequestMapping(value={"/user/dashboard"})
	public String userDashboard() {
		
		
		return "dashboard_user";
	} 
	
	@RequestMapping(value={"/admin/dashboard"})
	public String adminDashboard() {
		
		
		return "dashboard_admin";
	} 
	
}
