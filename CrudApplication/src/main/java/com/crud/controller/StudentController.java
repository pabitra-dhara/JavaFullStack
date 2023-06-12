package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//add new student
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		Student newStudent = this.studentService.createStudent(student);
		return newStudent;
	}
	
	//fetch all student details from db
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		List<Student> sudents = this.studentService.getSudents();
		return sudents;
	}
	
	//update student
	@PutMapping("/updateStudent/{id}")
	public Student updateStudent(@PathVariable("id") int id,@RequestBody Student student) {
		Student updatedStudent = this.studentService.updateStudent(id,student);
		return updatedStudent;
	}
	
	//delete Student
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		String deleteStatus = this.studentService.deleteStudent(id);
		return deleteStatus;
	}
}
