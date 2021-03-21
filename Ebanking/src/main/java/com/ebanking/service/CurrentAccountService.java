package com.ebanking.service;

import javax.servlet.http.HttpServletRequest;

import com.ebanking.entity.CurrentAccount;

public interface CurrentAccountService {
public Iterable<CurrentAccount> findAll();
	
	public CurrentAccount find(long id);
	
	public void save(CurrentAccount currentAccount);

	public void delete(long id);
	
	public CurrentAccount createNewCurrentAccount();
	
	public void deposit(int amount, HttpServletRequest request);
	
	public void withdraw(int amount, HttpServletRequest request);
}
