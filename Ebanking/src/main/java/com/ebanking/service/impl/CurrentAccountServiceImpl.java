package com.ebanking.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ebanking.dto.MyUser;
import com.ebanking.entity.CurrentAccount;
import com.ebanking.entity.Transaction;
import com.ebanking.entity.User;
import com.ebanking.repository.CurrentAccountRepository;
import com.ebanking.service.CurrentAccountService;
import com.ebanking.service.TransactionService;
import com.ebanking.service.UserService;

@Service("currentAccountService")
public class CurrentAccountServiceImpl implements CurrentAccountService {

	@Autowired
	private CurrentAccountRepository currentAccountRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Override
	public List<CurrentAccount> findAll() {
		return currentAccountRepository.findAll();
	}

	@Override
	public CurrentAccount find(long id) {
		return currentAccountRepository.findOne(id);
	}

	@Override
	public void save(CurrentAccount currentAccount) {
		currentAccountRepository.save(currentAccount);
	}

	@Override
	public void delete(long id) {
		currentAccountRepository.delete(id);
	}

	@Override
	public void deposit(int amount, User user, HttpServletRequest request) {
		user = userService.getCurrentUser();
		
		CurrentAccount currentAccount = user.getCurrentAccounts();
		int newBalance = currentAccount.getBalance() + amount;
		currentAccount.setBalance(newBalance);
		currentAccountRepository.save(currentAccount);
	}

	@Override
	public void withdraw(int amount, HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser)authentication.getPrincipal();
		long userId = myUser.getUserId();
		User user = userService.find(userId);
		
		CurrentAccount currentAccount = user.getCurrentAccounts();
		int newBalance = currentAccount.getBalance() - amount;
		currentAccount.setBalance(newBalance);
		currentAccountRepository.save(currentAccount);
	}

	@Override
	public CurrentAccount createNewCurrentAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changePinCode(CurrentAccount currentAccount, HttpServletRequest request) {
		currentAccount.setPinCode(request.getParameter("pinCode"));
	}

}
