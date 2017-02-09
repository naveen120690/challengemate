package com.challengemate.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	public @ResponseBody String registerUser(@RequestBody User user) {
		System.out.println(user);
		JSONObject gson = new JSONObject();
		try {
			int i = userService.registerUser(user);
			if (i == 0)
				gson.put("status", "success");
			else
				gson.put("status", "failure");

		} catch (Exception e) {
			if (e instanceof com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException) {
				gson.put("status", "failure");
				gson.put("cause", "Duplicate Data");
			}
		}
		return gson.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "userinfo/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getUserInfo(@PathVariable(value = "userid") String fbuserId) {
		System.out.println(fbuserId);
		JSONObject gson = new JSONObject();
		User user = this.userService.getUserInfo(fbuserId);
		if (user == null)
			gson.put("status", "User not found");
		else
			gson.put("user", user);
		return gson.toString();
	}

}