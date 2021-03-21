package com.ebanking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.entity.InterestRate;
import com.ebanking.repository.InterestRateRepository;
import com.ebanking.service.InterestRateService;

@Service("interestRateService")
public class InterestRateServiceImpl implements InterestRateService{

	@Autowired
	private InterestRateRepository interestRateRepository;
	
	@Override
	public Iterable<InterestRate> findAll() {
		return interestRateRepository.findAll();
	}

	@Override
	public InterestRate find(long id) {
		return interestRateRepository.findOne(id);
	}

	@Override
	public void save(InterestRate interestRate) {
		interestRateRepository.save(interestRate);
	}

	@Override
	public void delete(long id) {
		interestRateRepository.delete(id);
	}
}
