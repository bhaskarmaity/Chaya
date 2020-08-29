package com.org.MyChayaPrakashani.Controller;

import java.util.List;
import javax.persistence.NonUniqueResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.MyChayaPrakashani.DTO.CountStudentsInCourse;
import com.org.MyChayaPrakashani.DTO.StudentDetailsDTO;
import com.org.MyChayaPrakashani.Entity.Course;
import com.org.MyChayaPrakashani.Entity.Student;
import com.org.MyChayaPrakashani.Excepion.ResourceNotFoundException;
import com.org.MyChayaPrakashani.Service.CourseService;
import com.org.MyChayaPrakashani.Service.StudentService;

@RestController
public class GlobalController {
	@Autowired
	StudentService studentService;
	@Autowired 
	CourseService courseService;
	  
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/registerstudent")
	public String addStudent(@Valid @RequestBody Student student) throws NonUniqueResultException {
		return studentService.saveStudent(student);
	}  

	@GetMapping("/students")
	public List<StudentDetailsDTO>  getAllStudents(@RequestParam(defaultValue="0") Integer pageNo,
			@RequestParam(defaultValue="10") Integer pageSize,
			@RequestParam(defaultValue="id") String sortBy) {
		
		List<StudentDetailsDTO> listOfStudents=studentService.getAllStudent(pageNo,pageSize,sortBy);
		if(listOfStudents==null)
			throw new ResourceNotFoundException("No student present at this time..");
		return listOfStudents;
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/courses")
	public List<Course> getAllCourses(@RequestParam(defaultValue="0")Integer pageNo,
			@RequestParam(defaultValue="10")Integer pageSize,
			@RequestParam(defaultValue="courseId")String sortBy)	{
		return courseService.getAllCourse(pageNo,pageSize,sortBy).getContent();
	} 
	
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/course/{id}")
	public Course getCourseDetailsById(@PathVariable int id){
		Course course=courseService.getCourseById(id);
		return course;	
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("course1/{courseName}")
	public Course getCourseDetailsByName(@PathVariable String courseName){
		Course course=courseService.getCourseByName(courseName);
		return course;	
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/course/countbyid/{id}")
	public CountStudentsInCourse countCourseStudentById(@PathVariable int id)	{
		Course c=courseService.getCourseById(id);
		if(c==null)
			throw new ResourceNotFoundException("Course id "+id+" is not exists");
		return courseService.CountStudents(c.getCourseName());
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/course/countbycoursename/{courseName}")
	public CountStudentsInCourse countCourseStudentByCourseName(@PathVariable String courseName)	{
		Course c=courseService.getCourseByName(courseName);
		if(c==null)
			throw new ResourceNotFoundException("Course name "+courseName+" is not exists");
		return courseService.CountStudents(c.getCourseName());
	}
}