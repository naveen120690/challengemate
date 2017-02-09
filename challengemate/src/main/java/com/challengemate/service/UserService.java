package com.challengemate.service;

import com.challengemate.model.User;

public interface UserService {

	public int registerUser(User user);

	public User getUserInfo(String fbUserId);
}