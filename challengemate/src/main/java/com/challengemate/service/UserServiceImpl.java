package com.challengemate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengemate.dao.UserDAO;
import com.challengemate.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	public int registerUser(User user) {
		return userDAO.registerUser(user);
	}
}