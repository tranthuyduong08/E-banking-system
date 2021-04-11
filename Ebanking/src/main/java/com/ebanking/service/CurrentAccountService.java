package com.ebanking.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ebanking.entity.CurrentAccount;
import com.ebanking.entity.User;

public interface CurrentAccountService {
	public List<CurrentAccount> findAll();
	
	public CurrentAccount find(long id);
	
	public void save(CurrentAccount currentAccount);

	public void delete(long id);
	
	public CurrentAccount createNewCurrentAccount();
	
	public void deposit(int amount, User user, HttpServletRequest request);
	
	public void withdraw(int amount, HttpServletRequest request);
	
	public void changePinCode(CurrentAccount currentAccount, HttpServletRequest request);
}
