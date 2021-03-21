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
	
	@Autowired
	private CurrentAccountService currentAccountService;
	
	@Autowired
	private TransactionService transactionService;
	
// HOME CONTROLLER
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ModelAndView customerHomePage(ModelMap modelMap) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser)authentication.getPrincipal();
		long userId = myUser.getUserId();
		User user = userService.find(userId);
		
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
		
		// Get total Loan Amount
		List<LoanAccount> loanAccount = user.getLoanAccounts();
		int totalLoanBalance = 0;
		for(LoanAccount lA : loanAccount) {
			totalLoanBalance += lA.getRemainAmount();
		}
		modelMap.addAttribute("totalSavingAmount", totalLoanBalance);

		ModelAndView mav = new ModelAndView("customer/home");
		return mav;
	}
	

// TRANSACTION CONTROLLER	
	@RequestMapping(value = "/customer/transaction", method = RequestMethod.GET)
	public ModelAndView customerViewTransaction() {
		ModelAndView mav = new ModelAndView("customer/transaction/transaction-list");
		return mav;
	}
	
	@RequestMapping(value = "/customer/transaction/deposit/history", method = RequestMethod.GET)
	public ModelAndView customerViewDeposit(ModelMap modelMap) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser)authentication.getPrincipal();
		long userId = myUser.getUserId();
		User user = userService.find(userId);
		
		Iterable<Transaction> transaction = transactionService.findAll();
		//modelMap.put("transaction", transactionService.findByCurrentAccount(transaction, user.getCurrentAccounts()));
		//TODO: fix display only this user's one.
		modelMap.put("transaction", transaction);
		ModelAndView mav = new ModelAndView("customer/transaction/deposit-list");
		return mav;
	}
	
	@RequestMapping(value = "/customer/transaction/deposit", method = RequestMethod.GET)
	public ModelAndView customerCreateDeposit(ModelMap modelMap, Map<String, Object> model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser)authentication.getPrincipal();
		long userId = myUser.getUserId();
		User user = userService.find(userId);
		
		CurrentAccount currentAccount = user.getCurrentAccounts();
		modelMap.addAttribute("totalAmount", currentAccount.getBalance());
		
		ModelAndView mav = new ModelAndView("customer/transaction/create-deposit");
		Transaction transaction = new Transaction();
		model.put("transaction", transaction);
		return mav;
	}
	
	@RequestMapping(value = "/customer/transaction/deposit", method = RequestMethod.POST)
	public String customerCreateDeposit(@Valid Transaction transaction, BindingResult result, HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser)authentication.getPrincipal();
		long userId = myUser.getUserId();
		User user = userService.find(userId);
		
		transaction.setCurrentAccount(user.getCurrentAccounts());
		transaction.setAmount(Integer.parseInt(request.getParameter("amount")));
		transaction.setDate(new Date());
		transaction.setReceiver(user.getFirstName() + " " + user.getLastName());
		transaction.setType("Deposit");
		transaction.setDescription(request.getParameter("description"));
		
		currentAccountService.deposit(transaction.getAmount(), request);
		transactionService.save(transaction);
		return "redirect:/customer/transaction/deposit/history";
	}
	
	@RequestMapping(value = "/customer/transaction/withdraw/history", method = RequestMethod.GET)
	public ModelAndView customerViewWithdraw(ModelMap modelMap) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser)authentication.getPrincipal();
		long userId = myUser.getUserId();
		User user = userService.find(userId);
		
		Iterable<Transaction> transaction = transactionService.findAll();
		//modelMap.put("transaction", transactionService.findByCurrentAccount(transaction, user.getCurrentAccounts()));
		//TODO: fix display only this user's one.
		modelMap.put("transaction", transaction);
		
		ModelAndView mav = new ModelAndView("customer/transaction/withdraw-list");
		return mav;
	}
	
	@RequestMapping(value = "/customer/transaction/withdraw", method = RequestMethod.GET)
	public ModelAndView customerCreateWithdraw(ModelMap modelMap, Map<String, Object> model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser)authentication.getPrincipal();
		long userId = myUser.getUserId();
		User user = userService.find(userId);
		
		CurrentAccount currentAccount = user.getCurrentAccounts();
		modelMap.addAttribute("totalAmount", currentAccount.getBalance());
		
		ModelAndView mav = new ModelAndView("customer/transaction/create-withdraw");
		Transaction transaction = new Transaction();
		model.put("transaction", transaction);
		return mav;
	}
	
	@RequestMapping(value = "/customer/transaction/withdraw", method = RequestMethod.POST)
	public String customerCreateWithdraw(@Valid Transaction transaction, BindingResult result, HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser)authentication.getPrincipal();
		long userId = myUser.getUserId();
		User user = userService.find(userId);
		
		transaction.setCurrentAccount(user.getCurrentAccounts());
		transaction.setAmount(Integer.parseInt(request.getParameter("amount")));
		transaction.setDate(new Date());
		transaction.setReceiver(user.getFirstName() + " " + user.getLastName());
		transaction.setType("Withdraw");
		transaction.setDescription(request.getParameter("description"));
		
		currentAccountService.withdraw(transaction.getAmount(), request);
		transactionService.save(transaction);
		return "redirect:/customer/transaction/withdraw/history";
	}
	
	@RequestMapping(value = "/customer/transaction/transfer", method = RequestMethod.GET)
	public ModelAndView customerViewTransfer() {
		ModelAndView mav = new ModelAndView("customer/transaction/create-transfer");
		return mav;
	}
	
	@RequestMapping(value = "/customer/transaction/transfer/same-bank", method = RequestMethod.GET)
	public ModelAndView customerTransferSameBank() {
		ModelAndView mav = new ModelAndView("customer/transaction/transfer-same-bank");
		return mav;
	}
	
	@RequestMapping(value = "/customer/transaction/transfer/other-bank", method = RequestMethod.GET)
	public ModelAndView customerTransferOtherBank() {
		ModelAndView mav = new ModelAndView("customer/transaction/transfer-other-bank");
		return mav;
	}
}
