package com.ebanking.service;

import com.ebanking.entity.User;

public interface UserService {
	public Iterable<User> findAll();
	
	public User find(long id);
	
	public void hash(User user);
	
	public User save(User user);
	
	public User update(User user);
	
	public void delete(long id);
	
	public void bindRole(User user);
	
	public void deleteRole(User user);
	
	public int countAccount();
}
