package com.fernandospr.example.dao.impl;

import com.fernandospr.example.dao.StudentDao;
import com.fernandospr.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Override
    public List<Student> findAll() {
        return this.mongoTemplate.findAll(Student.class);
    }

    @Override
    public Student find(String id) {
        return this.mongoTemplate.findById(id, Student.class);
    }

    @Override
    public Student save(Student student) {
        this.mongoTemplate.save(student);
        return student;
    }

    @Override
    public Student update(String id, Student newStudent) {
        return this.save(newStudent);
    }

    @Override
    public void delete(Student student) {
        if (student != null) {
            this.mongoTemplate.remove(student);
        }
    }

    @Override
    public void deleteById(String id) {
        this.delete(this.find(id));
    }
}

