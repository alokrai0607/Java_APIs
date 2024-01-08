package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.CourseDTO;
import com.student.dto.StudentDTO;
import com.student.entity.Student;
import com.student.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admitStudent")
    public void admitStudent(@RequestBody StudentDTO studentDTO) {
        adminService.admitStudent(studentDTO);
    }

    @PostMapping("/uploadCourse")
    public void uploadCourse(@RequestBody CourseDTO courseDTO) {
        adminService.uploadCourse(courseDTO);
    }

    @PostMapping("/assignCourse/{studentId}/{courseId}")
    public void assignCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        adminService.assignCourse(studentId, courseId);
    }

    @GetMapping("/getStudentsByName/{name}")
    public List<Student> getStudentsByName(@PathVariable String name) {
        return adminService.getStudentsByName(name);
    }

    @GetMapping("/getStudentsByCourse/{courseId}")
    public List<Student> getStudentsByCourse(@PathVariable Long courseId) {
        return adminService.getStudentsByCourse(courseId);
    }
}
