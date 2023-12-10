package com.example.Register.Service;

import java.util.List;

import com.example.Register.Enity.User;

public interface UserService {

	public User saveUser(User user);

	public List<User> getAllUser();

	public User getUserById(long userId);

	public void delUserById(long userId);

	public User updateUser(Long userId, User user);

}
