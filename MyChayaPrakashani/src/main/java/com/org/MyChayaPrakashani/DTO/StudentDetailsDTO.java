package com.org.MyChayaPrakashani.DTO;

import java.util.ArrayList;
import java.util.List;

import com.org.MyChayaPrakashani.Entity.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetailsDTO {
	
	private Integer id;
	private String studentName;
	private String email;
	private String mobile;
	private String courseName;
	//private List<Course> courseName=new ArrayList<>();
	//private Course courseName;
	//private List<String> courseName=new ArrayList<>();
}
