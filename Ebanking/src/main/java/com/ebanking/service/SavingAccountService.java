package com.ebanking.service;

import com.ebanking.entity.SavingAccount;

public interface SavingAccountService {
	public Iterable<SavingAccount> findAll();
	
	public SavingAccount find(long id);
	
	public void save(SavingAccount savingAccount);

	public void delete(long id);
	
	public void hash(SavingAccount savingAccount);
}
