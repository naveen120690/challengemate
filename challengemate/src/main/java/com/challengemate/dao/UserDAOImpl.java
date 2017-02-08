package com.challengemate.dao;

import org.springframework.stereotype.Repository;

import com.challengemate.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	public int registerUser(User user) {
		return 1;
	}
}