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
		User user = new User();
		user.setFbuserid("fbuserid");
		// user.setDateOfBirth(LocalDate.now());
		user.setEmail("yogiverma1991@gmail.com");
		user.setMobile(9996868766l);
		user.setName("yoyo");
		user.setProfilePic("\\j\\k\\k\\abc.jpg");
		return user;
	}
}