package org.idb.TestSpringBoot.controller;

import org.idb.TestSpringBoot.entity.User;
import org.idb.TestSpringBoot.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private IUserRepo repo;

    @RequestMapping("/user")
    public String viewHome() {

        return "index";
    }

    @RequestMapping("/register")
    public String registerForm(Model m) {


        m.addAttribute("user", new User());
        m.addAttribute("title", "Add User");
        return "signup_form";
    }


    @RequestMapping("/user_reg")
    public String registerUser(@ModelAttribute("user") User u, Model m) {
        BCryptPasswordEncoder  encoder=new BCryptPasswordEncoder();
        String encodePass=encoder.encode(u.getPassword());
        u.setPassword(encodePass);
        repo.save(u);
        m.addAttribute("title", "Registration Success");
        return "redirect:/";
    }
}
