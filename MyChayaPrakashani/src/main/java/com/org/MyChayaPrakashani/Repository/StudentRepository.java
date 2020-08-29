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

import com.org.MyChayaPrakashani.DTO.StudentDetailsDTO;
import com.org.MyChayaPrakashani.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>,PagingAndSortingRepository<Student,Integer> {
	Optional<Student> findByemail(String email);
	boolean existsBymobile(String mobile);
	boolean existsByemail(String email);
	Page<Student> findAll(Pageable pg);
}