package com.simplepicpay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplepicpay.domain.user.User;
import com.simplepicpay.dtos.UserDTO;
import com.simplepicpay.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User findUserById(Long id) throws Exception {
		return this.repository.findUserById(id).orElseThrow(() -> new Exception("User not found"));
	}
	
	public void saveUser(User user) {
		this.repository.save(user);
	}

	public User createUser(UserDTO data) {
		User newUser = new User(data);
		this.saveUser(newUser);
		return newUser;
	}

	public List<User> getAllUsers() {
		return this.repository.findAll();
	}
}
