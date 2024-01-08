package com.student.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.CourseDTO;
import com.student.dto.StudentDTO;
import com.student.entity.Course;
import com.student.entity.Student;
import com.student.repository.CourseRepository;
import com.student.repository.StudentRepository;

@Service
public class AdminService {

 @Autowired
 private StudentRepository studentRepository;

 @Autowired
 private CourseRepository courseRepository;

 public void admitStudent(StudentDTO studentDTO) {
     Student student = new Student();
     BeanUtils.copyProperties(studentDTO, student);
     studentRepository.save(student);
 }

 public void uploadCourse(CourseDTO courseDTO) {
     Course course = new Course();
     BeanUtils.copyProperties(courseDTO, course);
     courseRepository.save(course);
 }

 public void assignCourse(Long studentId, Long courseId) {
     Student student = studentRepository.findById(studentId).orElse(null);
     Course course = courseRepository.findById(courseId).orElse(null);

     if (student != null && course != null) {
         student.getCourses().add(course);
         studentRepository.save(student);
     }
 }

 public List<Student> getStudentsByName(String name) {
     return studentRepository.findByName(name);
 }

 public List<Student> getStudentsByCourse(Long courseId) {
     Course course = courseRepository.findById(courseId).orElse(null);
     if (course != null) {
         return course.getStudents();
     }
     return null;
 }
}

