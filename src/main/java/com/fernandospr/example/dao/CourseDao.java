package com.fernandospr.example.dao;

import com.fernandospr.example.model.Course;

import java.util.List;

public interface CourseDao {

	List<Course> findAll();
	
	Course find(Integer id);
	
	Course save(Course course);

	Course update(Integer id, Course newCourse);

	void delete(Course student);
	
	void deleteById(Integer id);
}
