package com.ebanking.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ebanking.service.UserService;
import com.ebanking.dto.MyUser;
import com.ebanking.entity.User;

@Controller(value="adminController")
public class AdminController {

	@Autowired
	private UserService userService;
	
// HOME CONTROLLER
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminHomePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}
	
// PROFILE CONTROLLER
	@RequestMapping(value = "/admin/profile", method = RequestMethod.GET)
	public ModelAndView adminProfile(ModelMap modelMap) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser)authentication.getPrincipal();
		long userId = myUser.getUserId();
		User user = userService.find(userId);
		
		ModelAndView mav = new ModelAndView("admin/profile/profile");
		modelMap.addAttribute("user", user);
		return mav;
	}
	
	@RequestMapping(value = "/admin/profile/edit", method = RequestMethod.GET)
	public ModelAndView adminEditProfile() {
		ModelAndView mav = new ModelAndView("admin/profile/edit-profile");
		return mav;
	}
	
// CUSTOMER CONTROLLER
	@RequestMapping(value = "/admin/customer", method = RequestMethod.GET)
	public ModelAndView adminViewCustomer(ModelMap modelMap) {
		modelMap.put("user", userService.findAll());
		ModelAndView mav = new ModelAndView("admin/customer/customer-list");
		return mav;
	}
	
	@RequestMapping(value = "/admin/customer/create", method = RequestMethod.GET)
	public ModelAndView adminCreateCustomer(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("admin/customer/create-customer");
		return mav;
	}
	
	@RequestMapping(value = "/admin/customer/create", method = RequestMethod.POST)
	public String adminCreateCustomer(HttpServletRequest request) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
		User user = new User();	
		user.setFirstName(request.getParameter("firstName").trim());
		user.setLastName(request.getParameter("lastName").trim());
		user.setGender(request.getParameter("gender").trim());
		user.setDob(format.parse(request.getParameter("dob")));
		user.setPhone(request.getParameter("phone").trim());
		user.setEmail(request.getParameter("email").trim());
		user.setNationality(request.getParameter("nationality").trim());
		user.setCity(request.getParameter("city").trim());
		user.setAddress(request.getParameter("address").trim());
		user.setSalary(Integer.parseInt(request.getParameter("salary").trim()));
		user.setUsername(request.getParameter("username").trim());
		user.setPassword(request.getParameter("password").trim());
		
		userService.hash(user);		
		userService.save(user);
		userService.bindRole(user);
		return "redirect:/admin/customer";	
	}
	
	@RequestMapping(value = "/admin/customer/edit/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView adminEditCustomer(@PathVariable("id") long id, ModelMap modelMap) {
		User user = userService.find(id);
		modelMap.addAttribute("user", user);
		ModelAndView mav = new ModelAndView("admin/customer/edit-customer");
		return mav;
	}
	// TODO
	@RequestMapping(value = "/admin/customer/edit/{id}", method = RequestMethod.POST)
	public String adminEditCustomer(@PathVariable("id") Long id, HttpServletRequest request) {
		
		return "redirect:/admin/customer";
	}
	// TODO
	@RequestMapping(value = "/admin/customer/delete/{id}", method = RequestMethod.POST)
	public String adminDeleteCustomer(@PathVariable("id") Long id) {
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
