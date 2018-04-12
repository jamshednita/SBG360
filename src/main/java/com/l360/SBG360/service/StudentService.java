package com.l360.SBG360.service;

import java.util.List;

import com.l360.SBG360.bo.Student;

public interface StudentService {

	public Student getUniqueStudent(Integer id);
	
	public List<Student> getStudents(Integer limit);
	
	public Integer saveStudent(Student student);
	
	public void updateStudent(Student student);
	
	public void deleteStudent(Student student);
	
}
