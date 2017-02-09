package com.challengemate.dao;

import com.challengemate.model.User;

public interface UserDAO {
	
	public int registerUser(User user);
	
	public User getUserInfo(String fbUserId);

}