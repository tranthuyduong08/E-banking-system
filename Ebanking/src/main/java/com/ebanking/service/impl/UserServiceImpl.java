package com.ebanking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.entity.User;
import com.ebanking.service.UserService;
import com.ebanking.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public User find(long id) { 
		return userRepository.findOne(id);
	}

}
