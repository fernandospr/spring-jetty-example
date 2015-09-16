package com.fernandospr.example.dao.impl;

import com.fernandospr.example.dao.StudentDao;
import com.fernandospr.example.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("fakeStudentDao")
public class StudentFakeDaoImpl implements StudentDao {
	
	private static List<Student> students;
	private static String id = "1";
	static {
		students = new ArrayList<>(Arrays.asList(new Student("Foo Bar 1"),
				new Student("Foo Bar 2"),
				new Student("Foo Bar 3")));
		for(Student student : students) {
			student.setId(id);
			id = generateId(id);
		}
	}

	private static String generateId(String id) {
		Integer newId = Integer.parseInt(id) + 1;
		return newId.toString();
	}


	@Override
	public List<Student> findAll() {
		return students;
	}

	@Override
	public Student find(String id) {
		return students.stream()
		   .filter(s -> s.getId().equals(id))
		   .findFirst()
		   .orElse(null);
	}
	
	@Override
	public Student save(Student studentToSave) {
		setStudentId(studentToSave);
		students.add(studentToSave);
		return studentToSave;	
	}
	
	@Override
	public Student update(String id, Student newStudent) {
		Student studentToUpdate = this.find(id);
		if(studentToUpdate != null) {
			studentToUpdate.merge(newStudent);
			return studentToUpdate;
		} else {
			students.add(newStudent);
			return newStudent;
		}
	}

	private void setStudentId(Student studentToSave) {
		studentToSave.setId(id);
		id = generateId(id);
	}

	@Override
	public void delete(Student student) {
		students.remove(student);
	}

	@Override
	public void deleteById(String id) {
		Student student = this.find(id);
		this.delete(student);
	}
}
