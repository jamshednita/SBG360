package com.l360.SBG360.dao;

import java.util.List;

import com.l360.SBG360.bo.Student;

public interface StudentDAO {
	
	Student getStudentById(Integer id);
	
	List<Student> getStudents(Integer limit);
	
	Integer save(Student student);
	
	void update(Student student);
	
	void delete(Student student);

}