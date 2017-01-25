package com.smartkart.challengemate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smartkart.challengemate.model.Student;

@Repository
public class StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Student addStudent(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(student);
		return student;
	}
}
