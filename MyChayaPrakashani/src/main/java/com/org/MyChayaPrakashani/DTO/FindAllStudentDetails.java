package com.org.MyChayaPrakashani.DTO;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindAllStudentDetails {
	private Integer id;
	private String studentName;
	private String email;
	private String mobile;
	List<String> courseNames=new ArrayList<>();
}