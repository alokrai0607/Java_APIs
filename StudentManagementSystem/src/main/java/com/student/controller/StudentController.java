package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

 @Autowired
 private StudentService studentService;

 @GetMapping
 public List<Student> getAllStudents() {
     return studentService.getAllStudents();
 }

 @GetMapping("/{id}")
 public Student getStudentById(@PathVariable Long id) {
     return studentService.getStudentById(id);
 }


 @DeleteMapping("/delete/{id}")
 public void deleteStudent(@PathVariable Long id) {
     studentService.deleteStudent(id);
 }
 
}

