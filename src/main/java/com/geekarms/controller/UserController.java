package com.geekarms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geekarms.entity.User;
import com.geekarms.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public User add(@RequestParam String login) {
		return userService.addUser(login);
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public User update(@RequestParam Long id, @RequestParam String login) {
		return userService.update(id, login);
	}

	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public User findById(@RequestParam Long id) {
		return userService.findById(id);
	}

	@RequestMapping(value = "/findByLogin", method = RequestMethod.GET)
	public User findByLogin(@RequestParam String login) {
		return userService.findByLogin(login);
	}
}
