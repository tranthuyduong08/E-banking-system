package com.ebanking.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value="customerController")
public class CustomerController {
	
// HOME CONTROLLER
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	   public ModelAndView customerHomePage() {
	      ModelAndView mav = new ModelAndView("customer/home");
	      return mav;
	   }
	
// PROFILE CONTROLLER
	@RequestMapping(value = "/customer/profile", method = RequestMethod.GET)
	public ModelAndView customerProfile() {
		ModelAndView mav = new ModelAndView("customer/profile/profile");
		return mav;
	}
	
	@RequestMapping(value = "/customer/profile/edit", method = RequestMethod.GET)
	public ModelAndView customerEditProfile() {
		ModelAndView mav = new ModelAndView("customer/profile/edit-profile");
		return mav;
	}

// ACCOUNT CONTROLLER	
	@RequestMapping(value = "/customer/current-account", method = RequestMethod.GET)
	public ModelAndView customerViewCurrentAccount() {
		ModelAndView mav = new ModelAndView("customer/account/current-account");
		return mav;
	}
	
	@RequestMapping(value = "/customer/saving-account", method = RequestMethod.GET)
	public ModelAndView customerViewSavingAccount() {
		ModelAndView mav = new ModelAndView("customer/account/saving-account-list");
		return mav;
	}
	
	@RequestMapping(value = "/customer/saving-account/create", method = RequestMethod.GET)
	public ModelAndView customerCreateSavingAccount() {
		ModelAndView mav = new ModelAndView("customer/account/create-saving-account");
		return mav;
	}
	
	@RequestMapping(value = "/customer/loan-account", method = RequestMethod.GET)
	public ModelAndView customerViewLoanAccount() {
		ModelAndView mav = new ModelAndView("customer/account/loan-account-list");
		return mav;
	}
	
	@RequestMapping(value = "/customer/loan-account/create", method = RequestMethod.GET)
	public ModelAndView customerCreateLoanAccount() {
		ModelAndView mav = new ModelAndView("customer/account/create-loan-account");
		return mav;
	}
	
// TRANSACTION CONTROLLER	
	@RequestMapping(value = "/customer/transaction", method = RequestMethod.GET)
	public ModelAndView customerViewTransaction() {
		ModelAndView mav = new ModelAndView("customer/transaction/transaction-list");
		return mav;
	}
	
	@RequestMapping(value = "/customer/transaction/deposit/history", method = RequestMethod.GET)
	public ModelAndView customerViewDeposit() {
		ModelAndView mav = new ModelAndView("customer/transaction/deposit-list");
		return mav;
	}
	
	@RequestMapping(value = "/customer/transaction/deposit", method = RequestMethod.GET)
	public ModelAndView customerCreateDeposit() {
		ModelAndView mav = new ModelAndView("customer/transaction/create-deposit");
		return mav;
	}
	
	@RequestMapping(value = "/customer/transaction/withdraw/history", method = RequestMethod.GET)
	public ModelAndView customerViewWithdraw() {
		ModelAndView mav = new ModelAndView("customer/transaction/withdraw-list");
		return mav;
	}
	
	@RequestMapping(value = "/customer/transaction/withdraw", method = RequestMethod.GET)
	public ModelAndView customerCreateWithdraw() {
		ModelAndView mav = new ModelAndView("customer/transaction/create-withdraw");
		return mav;
	}
	
	@RequestMapping(value = "/customer/transaction/transfer", method = RequestMethod.GET)
	public ModelAndView customerViewTransfer() {
		ModelAndView mav = new ModelAndView("customer/transaction/transfer-list");
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
	
// APPOINTMENT CONTROLLER	
	@RequestMapping(value = "/customer/appointment", method = RequestMethod.GET)
	public ModelAndView customerViewAppointment() {
		ModelAndView mav = new ModelAndView("customer/appointment/appointment-list");
		return mav;
	}
	
	@RequestMapping(value = "/customer/appointment/create", method = RequestMethod.GET)
	public ModelAndView customerCreateAppointment() {
		ModelAndView mav = new ModelAndView("customer/appointment/create-appointment");
		return mav;
	}
	
	@RequestMapping(value = "/customer/appointment/delete", method = RequestMethod.GET)
	public String customerDeleteAppointment() {
		return "redirect:/customer/appointment";
	}
	
}
