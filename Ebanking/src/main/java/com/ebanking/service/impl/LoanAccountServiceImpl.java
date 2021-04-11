package com.ebanking.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.entity.InterestRate;
import com.ebanking.entity.LoanAccount;
import com.ebanking.entity.User;
import com.ebanking.repository.LoanAccountRepository;
import com.ebanking.service.LoanAccountService;

@Service("loanAccountService")
public class LoanAccountServiceImpl implements LoanAccountService{

	@Autowired
	private LoanAccountRepository loanAccountRepository;
	
	@Override
	public List<LoanAccount> findAll() {
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

	@Override
	public void createNewLoanAccount(LoanAccount loanAccount, User user, HttpServletRequest request) {
		InterestRate interestRate = new InterestRate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, Integer.parseInt(loanAccount.getTenor()));
		
		loanAccount.setAccNo((long)(Math.random() * 100000000 * 1000000)+"");
		loanAccount.setTenor(request.getParameter("tenor"));
		loanAccount.setUser(user);
		loanAccount.setOpenDate(new Date());		
		loanAccount.setCloseDate(calendar.getTime());
		loanAccount.setDescription(request.getParameter("description"));
		loanAccount.setTotalAmount(Integer.parseInt(request.getParameter("totalAmount")));
		loanAccount.setRemainAmount(loanAccount.getTotalAmount());
		loanAccount.setPinCode(request.getParameter("pinCode"));
		loanAccount.setStatus(0);	
	}

}
