package com.taskManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskManagement.Security.JwtUtil;
import com.taskManagement.Service.UserService;
import com.taskManagement.entity.User;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return service.register(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		User logged = service.login(user.getUsername(), user.getPassword());
		
		if(logged != null) {
			return JwtUtil.generateToken(user.getUsername());
		}
		return "Invalid credentials";
	}

}
