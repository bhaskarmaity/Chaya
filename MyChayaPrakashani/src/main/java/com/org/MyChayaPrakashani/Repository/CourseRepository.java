package com.org.MyChayaPrakashani.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.org.MyChayaPrakashani.DTO.CountStudentsInCourse;
import com.org.MyChayaPrakashani.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>,PagingAndSortingRepository<Course,Integer> {
	Course findBycourseId(int id);
	Course findBycourseName(String name);
	boolean existsBycourseId(int id);
	boolean existsBycourseName(String name);
	Page<Course> findAll(Pageable pg);
	
//	@Query("select new com.org.MyChayaPrakashani.DTO.CountStudentsInCourse(c.courseName, COUNT(s.id))"+
//			" FROM Student s JOIN s.courses c"+
//			" where c.courseName =?1"+   
//			" GROUP BY c.courseName order by c.courseName")
	
	@Query("select new com.org.MyChayaPrakashani.DTO.CountStudentsInCourse(c.courseName, COUNT(s.id))"+
			" FROM Student s JOIN s.courses c"+
			" where c.courseName =?1"+   
			" GROUP BY c.courseName")	
	CountStudentsInCourse countStudentByCourse(String courseName);
	}