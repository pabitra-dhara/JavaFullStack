package com.crud.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Student;
import com.crud.repository.StudentRepository;
import com.crud.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		Student newStudent = this.studentRepository.save(student);
		return newStudent;
	}

	@Override
	public List<Student> getSudents() {
		List<Student> students = this.studentRepository.findAll();
		return students;
	}

	@Override
	public Student updateStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		
	}

}
