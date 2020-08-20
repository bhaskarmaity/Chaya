package com.org.MyChayaPrakashani.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.org.MyChayaPrakashani.DTO.CountStudentsInCourse;
import com.org.MyChayaPrakashani.Entity.Course;
import com.org.MyChayaPrakashani.Excepion.IllegalSortingValueException;
import com.org.MyChayaPrakashani.Excepion.PagingException;
import com.org.MyChayaPrakashani.Excepion.ResourceNotFoundException;
import com.org.MyChayaPrakashani.Repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	public Page<Course>getAllCourse(Integer pageNo,Integer pageSize,String sortBy){

		List<String>sortProperties=new ArrayList<String>();
		sortProperties.add("courseId");sortProperties.add("courseName");
		sortProperties.add("courseTeacher");sortProperties.add("courseFee");
		if(!sortProperties.contains(sortBy))
			throw new IllegalSortingValueException(sortBy+" is not a valid option for sorting");
		if(pageSize<1 && pageNo<0)
			throw new PagingException(pageNo+","+pageSize+" is not a valid number for page number and page size");
		if(pageSize<1)
			throw new PagingException(pageSize+" is not a valid number for page size");
		if(pageNo<0)
			throw new PagingException(pageNo+" is not a valid number for page Number");
		
		Pageable paging=PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		return courseRepository.findAll(paging);
	}
	
	public Course getCourseById(int id)	{
		Course course=courseRepository.findBycourseId(id);
		if(course==null)
			throw new ResourceNotFoundException("Course with id : "+id+" is not Found");
		return course;
	}
	
	public Course getCourseByName(String name)	{
		Course course=courseRepository.findBycourseName(name);
		if(course==null)
			throw new ResourceNotFoundException("Course with name : "+name+" is not Found");
		return course;
	}
		
	public CountStudentsInCourse CountStudents(String courseName)	{
		CountStudentsInCourse c=courseRepository.countStudentByCourse(courseName);
		if(c==null)
			return new CountStudentsInCourse(courseName,0);
		return c;
	}
}