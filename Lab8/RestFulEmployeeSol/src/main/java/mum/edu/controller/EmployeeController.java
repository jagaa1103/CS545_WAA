package mum.edu.controller;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.edu.domain.Employee;
import mum.edu.exception.EmployeeException;
@Controller
public class EmployeeController {
	
	@RequestMapping(value={"/","/addEmployee"}, method = RequestMethod.GET)
	public String display() {
		return "employee";
	}
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)	
	public @ResponseBody Employee add(@Valid @RequestBody Employee employee) throws EmployeeException{
		return employee;
	}
}
