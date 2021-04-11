package com.ebanking.controller.customer;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebanking.dto.MyUser;
import com.ebanking.entity.CurrentAccount;
import com.ebanking.entity.LoanAccount;
import com.ebanking.entity.SavingAccount;
import com.ebanking.entity.Transaction;
import com.ebanking.entity.User;
import com.ebanking.service.CurrentAccountService;
import com.ebanking.service.TransactionService;
import com.ebanking.service.UserService;

@Controller(value="homeControllerOfCustomer")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
// HOME CONTROLLER
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ModelAndView customerHomePage(ModelMap modelMap) {
		User user = userService.getCurrentUser();
		
		// Get total Current Amount
		CurrentAccount currentAccount = user.getCurrentAccounts();
		modelMap.addAttribute("totalAmount", currentAccount.getBalance());
		modelMap.put("currentAccount", currentAccount);
		
		// Get total Saving Amount
		List<SavingAccount> savingAccount = user.getSavingAccounts();
		int totalSavingBalance = 0;
		for(SavingAccount sA : savingAccount) {
			totalSavingBalance += sA.getInitialAmount();
		}
		modelMap.addAttribute("totalSavingBalance", totalSavingBalance);
		//Iterate account management
		int savingAccCount = savingAccount.size();
		modelMap.put("savingAccCount", savingAccCount);
		
		// Get total remain Loan Amount
		List<LoanAccount> loanAccount = user.getLoanAccounts();
		int totalLoanBalance = 0;
		for(LoanAccount lA : loanAccount) {
			totalLoanBalance += lA.getRemainAmount();
		}
		modelMap.addAttribute("totalLoanBalance", totalLoanBalance);
		
		// Get total Transaction time 
		List<Transaction> transactions = user.getTransaction();
		modelMap.addAttribute("totalTransactionTime", transactions.size());

		ModelAndView mav = new ModelAndView("customer/home");
		return mav;
	}
}
