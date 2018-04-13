package com.ifi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.domain.Student;
import com.ifi.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
    private StudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> search(String q) {
        return studentRepository.findByNameContaining(q);
    }

    @Override
    public Student findOne(int id) {
        
    	return studentRepository.findOne(id);
    }

    @Override
    public void save(Student contact) {
    	studentRepository.save(contact);
    }

    @Override
    public void delete(int id) {
    	studentRepository.delete(id);
    }

}