package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByName(String name);
    
	
}