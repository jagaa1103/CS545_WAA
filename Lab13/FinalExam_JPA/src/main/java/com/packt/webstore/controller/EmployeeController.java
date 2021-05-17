package com.packt.webstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.packt.webstore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.domain.Employee;

@Controller
@RequestMapping({"/employees"})
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

 	@RequestMapping(value={"","/list"})
	public String listEmployees(Model model) {
 		model.addAttribute("employees", employeeService.findAll());
 		return "employees";
	}
	
  	@RequestMapping("/employee")
	public String getEmployeeByNumber(Model model, @RequestParam("id") Long employeeId) {
  		model.addAttribute("employee", employeeService.findByEmployeeId(employeeId));
		return "employee";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNewEmployee(@ModelAttribute("newEmployee") Employee newEmployee) {
	   return "addEmployee";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewEmployeeForm(@ModelAttribute("newEmployee") @Valid Employee employeeToBeAdded, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addEmployee";
		}
		try {
			employeeService.save(employeeToBeAdded);
		} catch (Exception up) {
			up.printStackTrace();
		}
		return "redirect:/employees/list";
	}
}
