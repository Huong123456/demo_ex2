package com.ifi.service;

import java.util.List;

import com.ifi.domain.Student;

public interface StudentService {

    Iterable<Student> findAll();

    List<Student> search(String q);

    Student findOne(int id);

    void save(Student student);

    void delete(int id);

}