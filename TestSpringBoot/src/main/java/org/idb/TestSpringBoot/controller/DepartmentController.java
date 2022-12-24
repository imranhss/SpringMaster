package org.idb.TestSpringBoot.controller;

import org.idb.TestSpringBoot.entity.Department;
import org.idb.TestSpringBoot.entity.Employee;
import org.idb.TestSpringBoot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @RequestMapping("/department/")
    public String departmentList(Model m) {

        List<Department> departmentList=service.getAllDep();
        m.addAttribute("departmentList", departmentList);
        m.addAttribute("title", "All Department");

        return  "department_list";
    }
}
