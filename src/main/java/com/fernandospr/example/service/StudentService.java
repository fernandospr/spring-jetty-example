package com.fernandospr.example.service;

import java.util.List;

import com.fernandospr.example.exceptions.ResourceAlreadyExistsException;
import com.fernandospr.example.model.Student;

public interface StudentService {
	List<Student> findAll();

	Student find(String id);
	
	boolean exists(String id);
	
	Student save(Student student) throws ResourceAlreadyExistsException;
	
	Student update(String id, Student newStudent);
	
	void delete(Student student);
}
