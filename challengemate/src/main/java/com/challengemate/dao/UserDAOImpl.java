package com.challengemate.dao;

import org.springframework.stereotype.Repository;

import com.challengemate.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Override
	public int registerUser(User user) {
		return 1;
	}
}