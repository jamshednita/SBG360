package com.l360.SBG360.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.l360.SBG360.bo.Student;

@Repository
public class StudentDAOImpl implements BaseDAO<Student> {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Student getById(Integer id) {
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public List<Student> getAll(Integer limit) {
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
		entityManager.merge(student);

	}

	@Override
	public void delete(Student student) {
		entityManager.remove(student);;
	}

}
