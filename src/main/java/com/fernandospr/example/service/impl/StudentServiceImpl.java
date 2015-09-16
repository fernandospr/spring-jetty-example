package com.fernandospr.example.service.impl;

import java.util.List;

import com.fernandospr.example.dao.StudentDao;
import com.fernandospr.example.exceptions.ResourceNotFoundException;
import com.fernandospr.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandospr.example.exceptions.ResourceAlreadyExistsException;
import com.fernandospr.example.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public Student find(String id) {
		Student student = studentDao.find(id);
		if (student == null) {
			throw new ResourceNotFoundException("Student with id " + id + " not found");
		}
		return student;
	}
	
	@Override
	public boolean exists(String id) {
		return studentDao.find(id) != null;
	}

	@Override
	public Student save(Student student) throws ResourceAlreadyExistsException {
		if (this.studentDao.find(student.getId()) != null) {
			throw new ResourceAlreadyExistsException("Student with id " + student.getId() + " already exists");
		}
		
		return this.studentDao.save(student);
	}

	@Override
	public Student update(String id, Student newStudent) {
    	
    	if (!id.equals(newStudent.getId()) && this.exists(newStudent.getId())) {
    		throw new ResourceAlreadyExistsException("Student with id " + newStudent.getId().toString() + " already exists");
    	}
		
		return this.studentDao.update(id, newStudent);
	}

	@Override
	public void delete(Student student) {
		this.studentDao.delete(student);
	}
}
