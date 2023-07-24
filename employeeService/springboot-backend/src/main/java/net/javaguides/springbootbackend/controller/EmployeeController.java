package net.javaguides.springbootbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
		//create emp
		@PostMapping("/employees")
		public Employee createEmployee(@RequestBody Employee employee) {
			return employeeRepository.save(employee);
		}
		
		//get employ by id 
		@GetMapping("/employees/{id}")
		public ResponseEntity<Employee> getEmployeeByd(@PathVariable Long id) {
			
			Employee employee=employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not Found This id:"+id));
			return ResponseEntity.ok(employee);
		}
		
		
		//update employee rest api
		@PutMapping("/employees/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
			Employee employee=employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not Found this id:"+id));
			employee.setFirstName(employeeDetails.getFirstName());
			employee.setLastName(employeeDetails.getLastName());
			employee.setEmailId(employeeDetails.getEmailId());
			
			Employee updatedEmployee=employeeRepository.save(employee);
			return ResponseEntity.ok(updatedEmployee);
		}
		
		//delete employee rest api
		@DeleteMapping("/employees/{id}")
		public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
			Employee employee=employeeRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Employee is not existwith id:"+id));
			
			employeeRepository.delete(employee);
			Map<String,Boolean>response=new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
}












