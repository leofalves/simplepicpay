package com.simplepicpay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplepicpay.domain.user.User;
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
}
