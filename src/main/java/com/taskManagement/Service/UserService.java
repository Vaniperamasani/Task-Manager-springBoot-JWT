package com.taskManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskManagement.Repository.UserRepo;
import com.taskManagement.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;

	public User register(User user) {
		return repo.save(user);
	}
	
	public User login(String username, String password) {
		User existing = repo.findByUsername(username);
		if(existing != null && existing.getPassword().equals(password)) {
			return existing;
		}
		return null;
	}
}
