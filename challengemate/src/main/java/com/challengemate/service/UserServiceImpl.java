package com.challengemate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challengemate.dao.UserDAO;
import com.challengemate.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Transactional
	public int registerUser(User user) {
		return userDAO.registerUser(user);
	}

	@Transactional
	public User getUserInfo(String fbUserId) {
		return userDAO.getUserInfo(fbUserId);
	}
}
