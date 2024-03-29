package com.student.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String dateOfBirth;
	private String gender;
	private String uniqueStudentCode;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<StudentAddress> addresses;

	@ManyToMany(mappedBy = "students")
	private List<Course> courses;

	public Student() {
		super();
		
	}

	public Student(Long id, String name, String dateOfBirth, String gender, String uniqueStudentCode,
			List<StudentAddress> addresses, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.uniqueStudentCode = uniqueStudentCode;
		this.addresses = addresses;
		this.courses = courses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUniqueStudentCode() {
		return uniqueStudentCode;
	}

	public void setUniqueStudentCode(String uniqueStudentCode) {
		this.uniqueStudentCode = uniqueStudentCode;
	}

	public List<StudentAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<StudentAddress> addresses) {
		this.addresses = addresses;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", uniqueStudentCode=" + uniqueStudentCode + ", addresses=" + addresses + ", courses=" + courses
				+ "]";
	}

}