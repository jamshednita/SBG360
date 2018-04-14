package com.l360.SBG360.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.l360.SBG360.bo.Student;
import com.l360.SBG360.dao.BaseDAO;
import com.l360.SBG360.exception.BusinessException;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	@Qualifier(value="studentDAOImpl")
	private BaseDAO<Student> studentDAO;

	@Override
	public Student getUniqueStudent(Integer id) {
		// DO business validation before hitting to DAO layer
		return studentDAO.getById(id);
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
		studentDAO.update(student);
	}

	@Override
	public void deleteStudent(Integer id) throws BusinessException{
		// DO business validation before hitting to DAO layer
		Student exists = studentDAO.getById(id);
		if(exists == null) {
			throw new BusinessException("Student does not exists with this ID "+id);
		}
		studentDAO.delete(exists);
	}

}
