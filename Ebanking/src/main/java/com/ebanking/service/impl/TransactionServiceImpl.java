package com.ebanking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.entity.CurrentAccount;
import com.ebanking.entity.Transaction;
import com.ebanking.entity.User;
import com.ebanking.service.TransactionService;
import com.ebanking.repository.TransactionRepository;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public Iterable<Transaction> findAll() {
		return transactionRepository.findAll();
	}

	@Override
	public Transaction find(long id) {
		return transactionRepository.findOne(id);
	}

	@Override
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);		
	}

	@Override
	public void delete(long id) {
		transactionRepository.delete(id);
	}

	@Override
	public List<Transaction> findByCurrentAccount(Iterable<Transaction> transactions, CurrentAccount currentAccount) {
		List<Transaction> filteredTransaction = new ArrayList<Transaction>();
		for(Transaction transaction: filteredTransaction) {
			if (currentAccount.equals(transaction.getCurrentAccount())) {
				filteredTransaction.add(transactionRepository.findOne(transaction.getId()));
			}
		}
		return null;
	}

}
