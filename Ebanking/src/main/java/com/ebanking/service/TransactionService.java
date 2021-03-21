package com.ebanking.service;

import java.util.List;

import com.ebanking.entity.Transaction;
import com.ebanking.entity.CurrentAccount;

public interface TransactionService {
	public Iterable<Transaction> findAll();
	
	public Transaction find(long id);
	
	public void save(Transaction transaction);

	public void delete(long id);
	
	public List<Transaction> findByCurrentAccount(Iterable<Transaction> transactions, CurrentAccount currentAccount);
	
}
