package com.ebanking.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebanking.service.TransactionService;

@Controller(value="transactionControllerOfAdmin")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	// TRANSACTION CONTROLLER
		@RequestMapping(value = "/admin/transaction/deposit", method = RequestMethod.GET)
		public ModelAndView adminViewDeposit(ModelMap modelMap) {
			modelMap.put("deposit", transactionService.findAllDeposit());
			ModelAndView mav = new ModelAndView("admin/transaction/deposit-list");
			return mav;
		}
		
		@RequestMapping(value = "/admin/transaction/withdraw", method = RequestMethod.GET)
		public ModelAndView adminViewWithdraw(ModelMap modelMap) {
			modelMap.put("withdraw", transactionService.findAllWithdraw());
			ModelAndView mav = new ModelAndView("admin/transaction/withdraw-list");
			return mav;
		}
		
		@RequestMapping(value = "/admin/transaction/transfer", method = RequestMethod.GET)
		public ModelAndView adminViewTransfer() {
			ModelAndView mav = new ModelAndView("admin/transaction/transfer-list");
			return mav;
		}
}
