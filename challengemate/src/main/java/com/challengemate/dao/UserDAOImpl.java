package com.challengemate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.challengemate.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public int registerUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String fbuserId = (String) session.save(user);
		tx.commit();
		session.close();
		if (fbuserId.isEmpty())
			return -1;
		else
			return 0;
	}

	@Override
	public User getUserInfo(String fbUserId) {
		Session session = sessionFactory.openSession();
		User user  = (User) session.get(User.class, fbUserId); 	
		return user;
	}
}