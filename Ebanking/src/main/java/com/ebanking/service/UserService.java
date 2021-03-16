package com.ebanking.service;

import com.ebanking.entity.User;

public interface UserService {
	public Iterable<User> findAll();
	
	public User find(long id);
}
