package com.ebanking.service;

import com.ebanking.entity.InterestRate;

public interface InterestRateService {
	public Iterable<InterestRate> findAll();
	
	public InterestRate find(long id);
	
	public void save(InterestRate interestRate);

	public void delete(long id);
}
