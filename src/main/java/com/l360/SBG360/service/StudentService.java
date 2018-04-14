package com.l360.SBG360.service;

import java.util.List;

import com.l360.SBG360.bo.Student;
import com.l360.SBG360.exception.BusinessException;

public interface StudentService {

	public Student getUniqueStudent(Integer id) throws BusinessException;
	
	public List<Student> getStudents(Integer limit);
	
	public Integer saveStudent(Student student);
	
	public void updateStudent(Student student) throws BusinessException;
	
	public void deleteStudent(Integer id) throws BusinessException;
	
}
