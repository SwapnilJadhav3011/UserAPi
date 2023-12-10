package com.example.Register.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Register.Enity.User;
import com.example.Register.Service.UserService;

import jakarta.validation.Valid;
@CrossOrigin(origins =  "http://localhost:3000")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveProduct")
	public User saveUser(@Valid
			@RequestBody User user)
	{
		return userService.saveUser(user);
	}
	
	@GetMapping("/")
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") long userId)
	{
		return userService.getUserById(userId);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String delUserById(@PathVariable("id") long userId)
	{
		userService.delUserById(userId);
		return "User Deleted Successfully";
	}
	
	@PutMapping("/editProduct/{id}")
	public User updateUser(@PathVariable("id") Long userId, @RequestBody User user)
	{
		return userService.updateUser(userId, user);
	}
}
