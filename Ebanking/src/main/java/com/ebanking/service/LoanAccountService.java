package com.ebanking.service;

import com.ebanking.entity.LoanAccount;

public interface LoanAccountService {
	public Iterable<LoanAccount> findAll();
	
	public LoanAccount find(long id);
	
	public void save(LoanAccount loanAccount);

	public void delete(long id);
}
