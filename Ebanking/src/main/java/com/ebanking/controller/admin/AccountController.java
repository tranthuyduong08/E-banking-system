package com.ebanking.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebanking.service.CurrentAccountService;
import com.ebanking.service.LoanAccountService;
import com.ebanking.service.SavingAccountService;

@Controller(value="accountControllerOfAdmin")
public class AccountController {
	
	@Autowired
	private CurrentAccountService currentAccountService;
	
	@Autowired
	private SavingAccountService savingAccountService;
	
	@Autowired
	private LoanAccountService loanAccountService;
	
	// ACCOUNT CONTROLLER
		@RequestMapping(value = "/admin/current-account", method = RequestMethod.GET)
		public ModelAndView adminViewCurrentAccount(ModelMap modelMap) {
			modelMap.put("currentAccount", currentAccountService.findAll());
			ModelAndView mav = new ModelAndView("admin/account/current-account-list");
			return mav;
		}

		@RequestMapping(value = "/admin/saving-account", method = RequestMethod.GET)
		public ModelAndView adminViewSavingAccount(ModelMap modelMap) {
			modelMap.put("savingAccount", savingAccountService.findAll());
			ModelAndView mav = new ModelAndView("admin/account/saving-account-list");
			return mav;
		}

		@RequestMapping(value = "/admin/loan-account", method = RequestMethod.GET)
		public ModelAndView adminViewLoanAccount(ModelMap modelMap) {
			modelMap.put("loanAccount", loanAccountService.findAll());
			ModelAndView mav = new ModelAndView("admin/account/loan-account-list");
			return mav;
		}
}
