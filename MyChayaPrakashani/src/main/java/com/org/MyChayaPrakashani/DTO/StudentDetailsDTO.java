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
	private int id;
	private String studentName;
	private String email;
	private List<String> courseName=new ArrayList<>();
	
}
