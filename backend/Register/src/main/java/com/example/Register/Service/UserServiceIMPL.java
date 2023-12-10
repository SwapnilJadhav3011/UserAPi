package com.example.Register.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Register.Enity.User;
import com.example.Register.Repository.UserRepository;

@Service
public class UserServiceIMPL implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).get();
	}

	@Override
	public void delUserById(long userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}

	@Override
	public User updateUser(Long userId, User user) {
		// TODO Auto-generated method stub
		User userDB=userRepository.findById(userId).get();
		
		if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
			userDB.setName(user.getName());
		}
		if (Objects.nonNull(user.getPhoneNumber()) && !"".equalsIgnoreCase(user.getName())) {
			userDB.setPhoneNumber(user.getPhoneNumber());
		}
		if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getName())) {
			userDB.setEmail(user.getEmail());
		}
		if (Objects.nonNull(user.getHobbies()) && !"".equalsIgnoreCase(user.getName())) {
			userDB.setHobbies(user.getHobbies());
		}
		
		return userRepository.save(userDB);
	}

}
