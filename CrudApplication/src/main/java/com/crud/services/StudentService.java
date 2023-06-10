package com.crud.services;

import java.util.List;

import com.crud.entity.Student;

public interface StudentService {

	public Student createStudent(Student student);
	public List<Student> getSudents();
	public Student updateStudent(int id);
	public void deleteStudent(int id);
	
}
