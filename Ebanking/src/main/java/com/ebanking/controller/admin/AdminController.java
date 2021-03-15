package com.ebanking.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value="adminController")
public class AdminController {

// HOME CONTROLLER
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminHomePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}
	
// PROFILE CONTROLLER
	@RequestMapping(value = "/admin/profile", method = RequestMethod.GET)
	public ModelAndView adminProfile() {
		ModelAndView mav = new ModelAndView("admin/profile/profile");
		return mav;
	}
	
	@RequestMapping(value = "/admin/profile/edit", method = RequestMethod.GET)
	public ModelAndView adminEditProfile() {
		ModelAndView mav = new ModelAndView("admin/profile/edit-profile");
		return mav;
	}
	
// CUSTOMER CONTROLLER
	@RequestMapping(value = "/admin/customer", method = RequestMethod.GET)
	public ModelAndView adminViewCustomer() {
		ModelAndView mav = new ModelAndView("admin/customer/customer-list");
		return mav;
	}
	
	@RequestMapping(value = "/admin/customer/create", method = RequestMethod.GET)
	public ModelAndView adminCreateCustomer() {
		ModelAndView mav = new ModelAndView("admin/customer/create-customer");
		return mav;
	}
	
	@RequestMapping(value = "/admin/customer/edit", method = RequestMethod.GET)
	public ModelAndView adminEditCustomer() {
		ModelAndView mav = new ModelAndView("admin/customer/edit-customer");
		return mav;
	}
	
	@RequestMapping(value = "/admin/customer/delete", method = RequestMethod.GET)
	public String adminDeleteCustomer() {
		return "redirect:/admin/customer";
	}

// ACCOUNT CONTROLLER
	@RequestMapping(value = "/admin/interest-rate", method = RequestMethod.GET)
	   public ModelAndView adminViewInterestRate() {
	      ModelAndView mav = new ModelAndView("admin/interest-rate-list");
		      return mav;
		   }
	
	@RequestMapping(value = "/admin/current-account", method = RequestMethod.GET)
	   public ModelAndView adminViewCurrentAccount() {
	      ModelAndView mav = new ModelAndView("admin/account-list");
		      return mav;
		   }
	
	@RequestMapping(value = "/admin/saving-account", method = RequestMethod.GET)
	   public ModelAndView adminViewSavingAccount() {
	      ModelAndView mav = new ModelAndView("admin/account-list");
		      return mav;
		   }
	
	@RequestMapping(value = "/admin/loan-account", method = RequestMethod.GET)
	   public ModelAndView adminViewLoanAccount() {
	      ModelAndView mav = new ModelAndView("admin/account-list");
		      return mav;
		   }
}
