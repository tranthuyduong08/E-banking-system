package com.ebanking.controller.customer;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebanking.dto.MyUser;
import com.ebanking.entity.CurrentAccount;
import com.ebanking.entity.InterestRate;
import com.ebanking.entity.LoanAccount;
import com.ebanking.entity.SavingAccount;
import com.ebanking.entity.User;
import com.ebanking.service.LoanAccountService;
import com.ebanking.service.SavingAccountService;
import com.ebanking.service.UserService;

@Controller(value = "accountControllerOfCustomer")
public class AccountController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SavingAccountService savingAccountService;
	
	@Autowired
	private LoanAccountService loanAccountService;

	// ACCOUNT CONTROLLER
	@RequestMapping(value = "/customer/current-account", method = RequestMethod.GET)
	public ModelAndView customerViewCurrentAccount(ModelMap modelMap) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser) authentication.getPrincipal();
		long userId = myUser.getUserId();
		User user = userService.find(userId);

		CurrentAccount currentAccount = user.getCurrentAccounts();
		modelMap.put("currentAccount", currentAccount);
		ModelAndView mav = new ModelAndView("customer/account/current-account");
		return mav;
	}

	@RequestMapping(value = "/customer/saving-account", method = RequestMethod.GET)
	public ModelAndView customerViewSavingAccount(ModelMap modelMap) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser) authentication.getPrincipal();
		long userId = myUser.getUserId();
		User user = userService.find(userId);

		List<SavingAccount> savingAccounts = user.getSavingAccounts();
		modelMap.put("savingAccounts", savingAccounts);
		ModelAndView mav = new ModelAndView("customer/account/saving-account-list");
		return mav;
	}

	@RequestMapping(value = "/customer/saving-account/create", method = RequestMethod.GET)
	public ModelAndView customerCreateSavingAccount(Map<String, Object> model) {
		ModelAndView mav = new ModelAndView("customer/account/create-saving-account");
		SavingAccount savingAccount = new SavingAccount();
		model.put("savingAccount", savingAccount);
		return mav;
	}
	
	@RequestMapping(value = "/customer/saving-account/create", method = RequestMethod.POST)
	public String customerCreateSavingAccount(@Valid SavingAccount savingAccount, BindingResult result, HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser)authentication.getPrincipal();
		long userId = myUser.getUserId();
		User user = userService.find(userId);
		
		InterestRate interestRate = new InterestRate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, Integer.parseInt(savingAccount.getTenor()));
		
		savingAccount.setAccNo((long)(Math.random() * 100000000 * 1000000)+"");
		savingAccount.setTenor(request.getParameter("tenor"));
		savingAccount.setUser(user);
		savingAccount.setOpenDate(new Date());		
		savingAccount.setCloseDate(calendar.getTime());
		savingAccount.setDescription(request.getParameter("description"));
		savingAccount.setInitialAmount(Integer.parseInt(request.getParameter("initialAmount")));
		savingAccount.setPinCode(request.getParameter("pinCode"));
		//savingAccountService.hash(savingAccount);
		savingAccountService.save(savingAccount);		
		return "redirect:/customer/saving-account";
	}

	@RequestMapping(value = "/customer/loan-account", method = RequestMethod.GET)
	public ModelAndView customerViewLoanAccount(ModelMap modelMap) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser) authentication.getPrincipal();
		long userId = myUser.getUserId();
		User user = userService.find(userId);

		List<LoanAccount> loanAccounts = user.getLoanAccounts();
		modelMap.put("loanAccounts", loanAccounts);
		ModelAndView mav = new ModelAndView("customer/account/loan-account-list");
		return mav;
	}

	@RequestMapping(value = "/customer/loan-account/create", method = RequestMethod.GET)
	public ModelAndView customerCreateLoanAccount(Map<String, Object> model) {
		ModelAndView mav = new ModelAndView("customer/account/create-loan-account");
		LoanAccount loanAccount = new LoanAccount();
		model.put("loanAccount", loanAccount);
		return mav;
	}
	
	@RequestMapping(value = "/customer/loan-account/create", method = RequestMethod.POST)
	public String customerCreateLoanAccount(@Valid LoanAccount loanAccount, BindingResult result, HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser)authentication.getPrincipal();
		long userId = myUser.getUserId();
		User user = userService.find(userId);
		
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
		loanAccountService.save(loanAccount);		
		return "redirect:/customer/loan-account";
	}

}
