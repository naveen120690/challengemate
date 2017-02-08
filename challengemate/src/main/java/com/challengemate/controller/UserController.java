package com.challengemate.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.challengemate.model.User;
import com.challengemate.service.UserService;

@Controller
@RequestMapping(value = "/user/")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String loadData() {
		System.out.println("came in loadDataa");
		return "hiiiii world";
	}

	@RequestMapping(method = RequestMethod.POST, value = "registeruser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registerUser(User user) {
		System.out.println(user);
		JSONObject gson = new JSONObject();
		int retVal = userService.registerUser(user);
		if (retVal == 1)
			gson.put("status", "success");
		else
			gson.put("status", "fail");
		return gson.toString();
	}

}