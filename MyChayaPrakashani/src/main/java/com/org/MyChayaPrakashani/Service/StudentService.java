package com.org.MyChayaPrakashani.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.org.MyChayaPrakashani.DTO.StudentDetailsDTO;
import com.org.MyChayaPrakashani.Entity.Course;
import com.org.MyChayaPrakashani.Entity.Student;
import com.org.MyChayaPrakashani.Excepion.DuplicateEntryException;
import com.org.MyChayaPrakashani.Excepion.IllegalSortingValueException;
import com.org.MyChayaPrakashani.Excepion.InvalidRoleException;
import com.org.MyChayaPrakashani.Excepion.PagingException;
import com.org.MyChayaPrakashani.Excepion.RegistrationFailedException;
import com.org.MyChayaPrakashani.Excepion.ResourceNotFoundException;
import com.org.MyChayaPrakashani.Repository.CourseRepository;
import com.org.MyChayaPrakashani.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired 
	CourseRepository courseRepository;
	
//	public List<Student> getAllStudent(int pageNo,int pageSize,String sortBy)	{
//		
//		 List<String>sortProperties=new ArrayList<String>();
//			sortProperties.add("id");sortProperties.add("studentName");
//			sortProperties.add("email");sortProperties.add("mobile");
//			
//		if(!sortProperties.contains(sortBy))
//			throw new IllegalSortingValueException(sortBy+" is not a valid option for sorting");
//		
//		if(pageSize<1 && pageNo<0)
//			throw new PagingException(pageNo+","+pageSize+" is not a valid number for page number and page size");
//		if(pageSize<1)
//			throw new PagingException(pageSize+" is not a valid number for page size");
//		if(pageNo<0)
//			throw new PagingException(pageNo+" is not a valid number for page Number");
//		Pageable paging=PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//
//		 return studentRepository.findAll(paging).getContent();
//	}
	

	
		
	private StudentDetailsDTO  convertToUserDetailsDTO(Student student)
	{
		StudentDetailsDTO std=new StudentDetailsDTO();
		std.setStudentName(student.getStudentName());
		std.setId(student.getId());
		std.setEmail(student.getEmail());
		student.getCourses().forEach((n) -> std.getCourseName().add(n.getCourseName()));
		return std;
	}
	
	public List<StudentDetailsDTO> getAllStudent(int pageNo,int pageSize,String sortBy)	{
		
		 List<String>sortProperties=new ArrayList<String>();
			sortProperties.add("id");sortProperties.add("studentName");
			sortProperties.add("email");sortProperties.add("mobile");
			
		if(!sortProperties.contains(sortBy))
			throw new IllegalSortingValueException(sortBy+" is not a valid option for sorting");
		
		if(pageSize<1 && pageNo<0)
			throw new PagingException(pageNo+","+pageSize+" is not a valid number for page number and page size");
		if(pageSize<1)
			throw new PagingException(pageSize+" is not a valid number for page size");
		if(pageNo<0)
			throw new PagingException(pageNo+" is not a valid number for page Number");
		Pageable paging=PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		 return ((List<Student>) studentRepository
	                .findAll(paging).getContent()).stream()
	                .map(this::convertToUserDetailsDTO)
					        .collect(Collectors.toList());
	}
	
	
	
	
	
	public String saveStudent(Student student)	{
		
		Student newStudent=new Student();
		newStudent.setEmail(student.getEmail());
		newStudent.setId(student.getId());
		newStudent.setMobile(student.getMobile());
		newStudent.setPassword(student.getPassword());
		if(!studentRepository.existsBymobile(student.getMobile()))
			newStudent.setMobile(student.getMobile());
		else
			throw new DuplicateEntryException("Mobile number "+student.getMobile()+" is already exists");
		
		if(!studentRepository.existsByemail(student.getEmail()))
			newStudent.setEmail(student.getEmail());
		else
			throw new DuplicateEntryException("Email id "+student.getEmail()+" is already exists");
		
		if(student.getRole()!=null)
		{
			if(student.getRole().equals("USER")||student.getRole().equals("ADMIN"))
				newStudent.setRole(student.getRole());
			else
				throw new InvalidRoleException(student.getRole()+" is not a valid role"); 
		}
		else
			newStudent.setRole("USER");
				
		newStudent.setStudentName(student.getStudentName());
		List<Course> courseList = (List<Course>) student.getCourses();
		int cnt=0;
		for (Course course : courseList) {
		Integer courseId = course.getCourseId();
		if (!courseRepository.existsBycourseId(courseId)) {
			throw new  ResourceNotFoundException("Course Not Found for course id : " + courseId);
		}
		cnt++;
	}
		if(cnt!=courseList.size())
			throw new RegistrationFailedException("Registration is failed");
		
		newStudent.getCourses().addAll(student.getCourses().stream().map(courses ->{
			Course course=courseRepository.findBycourseId(courses.getCourseId());
			course.getStudents().add(newStudent);
			return course;
		}).collect(Collectors.toList()));
		
		studentRepository.save(newStudent);
		return "Successfully created";
	}
}