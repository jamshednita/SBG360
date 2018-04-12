package com.l360.SBG360.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.l360.SBG360.bo.Student;
import com.l360.SBG360.dao.StudentDAO;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public Student getUniqueStudent(Integer id) {
		// DO business validation before hitting to DAO layer
		return studentDAO.getStudentById(id);
	}

	@Override
	public List<Student> getStudents(Integer limit) {
		// DO business validation before hitting to DAO layer
		return null;
	}

	@Override
	public Integer saveStudent(Student student) {
		// DO business validation before hitting to DAO layer
		return studentDAO.save(student);
	}

	@Override
	public void updateStudent(Student student) {
		// DO business validation before hitting to DAO layer

	}

	@Override
	public void deleteStudent(Student student) {
		// DO business validation before hitting to DAO layer

	}

}