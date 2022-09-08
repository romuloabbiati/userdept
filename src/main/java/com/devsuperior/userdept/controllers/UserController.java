package com.devsuperior.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	@GetMapping(value = "/{userId}")
	public User findById(@PathVariable Long userId) {
		User user = userRepository.findById(userId).get();
		return user;
	}
	
	@PostMapping
	public User insert(@RequestBody User user) {
		User result = userRepository.save(user);
		return user;
	}
	
}
