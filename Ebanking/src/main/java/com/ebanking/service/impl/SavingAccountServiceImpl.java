package com.ebanking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ebanking.entity.SavingAccount;
import com.ebanking.entity.User;
import com.ebanking.repository.SavingAccountRepository;
import com.ebanking.service.SavingAccountService;

@Service("savingAccountService")
public class SavingAccountServiceImpl implements SavingAccountService{

	@Autowired
	private SavingAccountRepository savingAccountRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Iterable<SavingAccount> findAll() {
		return savingAccountRepository.findAll();
	}

	@Override
	public SavingAccount find(long id) {
		return savingAccountRepository.findOne(id);
	}

	@Override
	public void save(SavingAccount savingAccount) {
		savingAccountRepository.save(savingAccount);
	}

	@Override
	public void delete(long id) {
		savingAccountRepository.delete(id);
	}
	
	@Override
	public void hash(SavingAccount savingAccount) {
		savingAccount.setPinCode(bCryptPasswordEncoder.encode(savingAccount.getPinCode()));	
	}
}
