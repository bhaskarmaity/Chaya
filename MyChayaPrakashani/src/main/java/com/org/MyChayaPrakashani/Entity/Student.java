package com.org.MyChayaPrakashani.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
//@Table(uniqueConstraints= @UniqueConstraint(name="uniqEmail",columnNames= {"email"}))
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentid_generator")
	@SequenceGenerator(name = "studentid_generator", allocationSize = 1,sequenceName = "studentid_seq")
	@Column(name = "student_id")
	private Integer id;
	
	@NotNull(message="Name not be null")
	@Column(name="student_name")
	private String studentName;
	
	@Email(regexp="\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b",message="Email must be well formed")
	private String email;
	
	@NotNull(message="Password not be null")
	@Size(min=3,message="Password must be >3 characters")
	private String password;
	
	@NotNull()
	@Size(min=10,max=10,message="Phone number mustbe 10 digits")
	private String mobile;
	
	private String role;
	
	@ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
	List<Course> courses=new ArrayList<>();
	
	public Student(Student s) {
		this.id=s.id;
		this.studentName =s.studentName ;
		this.email = s.email;
		this.password = s.password;
		this.mobile = s.mobile;
		this.role = s.role;
		this.courses = s.courses;
	}
	
	public Student(String name, String email, String password, String mobile, String role, ArrayList<Course> courses) {
		this.studentName =name ;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.role = role;
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", email=" + email + ", password=" + password
				+ ", mobile=" + mobile + ", role=" + role + "]";
	}
}