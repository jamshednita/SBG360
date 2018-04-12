package com.l360.SBG360.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.l360.SBG360.bo.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Student getStudentById(Integer id) {
		Student student = entityManager.find(Student.class, id);
		
		return student;
	}

	@Override
	public List<Student> getStudents(Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer save(Student student) {
		entityManager.persist(student);
		return student.getId();
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub

	}

}