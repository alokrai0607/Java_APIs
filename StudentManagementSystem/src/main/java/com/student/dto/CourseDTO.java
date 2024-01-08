package com.student.dto;

public class CourseDTO {

	private String name;
	private String description;
	private String courseType;
	private String duration;

	public CourseDTO() {
		super();
	}

	public CourseDTO(String name, String description, String courseType, String duration) {
		super();
		this.name = name;
		this.description = description;
		this.courseType = courseType;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "CourseDTO [name=" + name + ", description=" + description + ", courseType=" + courseType + ", duration="
				+ duration + "]";
	}

}
