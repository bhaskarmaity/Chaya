package com.org.MyChayaPrakashani.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.org.MyChayaPrakashani.DTO.DT;
import com.org.MyChayaPrakashani.DTO.StudentDetailsDTO;
import com.org.MyChayaPrakashani.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>,PagingAndSortingRepository<Student,Integer> {
	Optional<Student> findBystudentName(String name);
	Optional<Student> findByemail(String email);
	boolean existsBymobile(String mobile);
	boolean existsByemail(String email);
	Page<Student> findAll(Pageable pg);

	
	@Query("select new com.org.MyChayaPrakashani.DTO.StudentDetailsDTO(s.id,s.studentName,"
			+ "s.email,s.mobile,c.courseName) from Student s join s.courses c")
	
//@Query(value="select new com.org.MyChayaPrakashani.DTO.StudentDetailsDTO(s.student_name,group_concat(c.course_name)) from "
//		+ "student s,course c,students_courses sc where sc.course_id=c.course_id"
//		+ " and sc.student_id=s.student_id group by sc.student_id",nativeQuery = true)

//	@Query("select new com.org.MyChayaPrakashani.DTO.StudentDetailsDTO(s.id,s.studentName,s.email,s.mobile,c.courseName)"
//			+ "from Student s inner join s.courses c group by s.id")

 Page<StudentDetailsDTO> findAllStudents(Pageable pg);
}