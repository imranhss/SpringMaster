package org.idb.TestSpringBoot.controller;

import org.idb.TestSpringBoot.entity.Employee;
import org.idb.TestSpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller

public class EmployeeController {

    @Autowired
    EmployeeService service;

    @RequestMapping(value = {"/", "/index"})
    public  String home(){

        return "index";
    }

    @RequestMapping("/emp_list")
    public String allEmp(Model m){
        List<Employee> employeeList=service.getAllEmp();
        m.addAttribute("employeeList", employeeList);
        m.addAttribute("title", "All Employee");
        return "employee_list";
    }

    @RequestMapping("/emp_save_form")
    public  String empSaveForm(Model m){
        m.addAttribute("employee", new Employee());
        return "emp_save_form";
    }
    @RequestMapping(value = "/emp_save", method = RequestMethod.POST)
    public  String empSave(@ModelAttribute("employee") Employee e, Model m){
        service.saveEmp(e);
        m.addAttribute("title", "Add Employee");
        return "redirect:/emp_list";
    }

    @RequestMapping("/emp_delete/{eid}")
    public  String empDelete(@PathVariable("eid") Integer eid){
        service.deleteEmp(eid);
        return "redirect:/emp_list";
    }

    @RequestMapping("/emp_edit/{eid}")
    public  String empEditForm(@PathVariable("eid") Integer eid, Model m){
         Employee e=service.findEmpById(eid);
         m.addAttribute("employee", e);
        return "emp_save_form";
    }



}
