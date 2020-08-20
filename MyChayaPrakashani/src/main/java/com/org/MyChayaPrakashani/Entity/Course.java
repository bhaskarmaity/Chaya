package com.org.MyChayaPrakashani.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Data
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseid_generator")
	@SequenceGenerator(name = "courseid_generator", allocationSize = 1,sequenceName = "courseid_seq")
	@Column(name = "course_id")
	private Integer courseId;
	
	@Column(name="course_name")
	private String courseName;
	@Column(name="course_teacher")
	private String courseTeacher;
	@Column(name="course_fee")
	private int courseFee;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonIgnore
    private List<Student> students = new ArrayList<>();

	public Course(String courseName, String courseTeacher, int courseFee, ArrayList<Student> students) {
		this.courseName = courseName;
		this.courseTeacher = courseTeacher;
		this.courseFee = courseFee;
		this.students = students;
	}
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseTeacher=" + courseTeacher
				+ ", courseFee=" + courseFee + "]";
	}
}
