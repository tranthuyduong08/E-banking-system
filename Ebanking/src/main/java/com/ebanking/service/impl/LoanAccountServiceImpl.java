package com.ebanking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.entity.LoanAccount;
import com.ebanking.repository.LoanAccountRepository;
import com.ebanking.service.LoanAccountService;

@Service("loanAccountService")
public class LoanAccountServiceImpl implements LoanAccountService{

	@Autowired
	private LoanAccountRepository loanAccountRepository;
	
	@Override
	public Iterable<LoanAccount> findAll() {
		return loanAccountRepository.findAll();
	}

	@Override
	public LoanAccount find(long id) {
		return loanAccountRepository.findOne(id);
	}

	@Override
	public void save(LoanAccount loanAccount) {
		loanAccountRepository.save(loanAccount);
	}

	@Override
	public void delete(long id) {
		loanAccountRepository.delete(id);
	}

}
