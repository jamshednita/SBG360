package com.l360.SBG360.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.l360.SBG360.bo.Student;
@Repository
public class StudentDAOHibernateImpl implements StudentDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Student getStudentById(Integer id) {
		/*System.out.println("Inside StudentDAOHibernateImpl");
		if(entityManager.unwrap(Session.class) !=null) {
			System.out.println("entityManager contains hibernate session");
		}*/
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<Student> criteria = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = criteria.from(Student.class);
		
		criteria.select(root);
		criteria.where(criteriaBuilder.equal(root.get("id"), id));
		
		return entityManager.createQuery(criteria).getSingleResult();
	}

	@Override
	public List<Student> getStudents(Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer save(Student student) {
		return null;//(Integer) hibernateTemplate.save(student);
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
