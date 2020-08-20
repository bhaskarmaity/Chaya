package com.org.MyChayaPrakashani.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountStudentsInCourse {
	private String courseName;
	private long studentNumber;
}
