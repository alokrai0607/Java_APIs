package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
