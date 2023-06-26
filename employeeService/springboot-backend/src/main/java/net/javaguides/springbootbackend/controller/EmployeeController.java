package net.javaguides.springbootbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springbootbackend.entity.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;

@CrossOrigin("*")
@RestController
public class EmployeeController {

		@Autowired
		private EmployeeRepository employeeRepository;
		
		//get all emp
		@GetMapping("/employees")
		public List<Employee> getAllEmployees(){
			return employeeRepository.findAll();
		}
}
