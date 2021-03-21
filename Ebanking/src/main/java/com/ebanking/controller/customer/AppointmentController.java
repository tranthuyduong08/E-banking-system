package com.ebanking.controller.customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebanking.dto.MyUser;
import com.ebanking.entity.Appointment;
import com.ebanking.entity.User;
import com.ebanking.service.AppointmentService;
import com.ebanking.service.UserService;

@Controller(value="appointmentControllerOfCustomer")
public class AppointmentController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	// APPOINTMENT CONTROLLER	
		@RequestMapping(value = "/customer/appointment", method = RequestMethod.GET)
		public ModelAndView customerViewAppointment(ModelMap modelMap) {
			modelMap.put("appointment", appointmentService.findAll());
			ModelAndView mav = new ModelAndView("customer/appointment/appointment-list");
			return mav;
		}
		
		@RequestMapping(value = "/customer/appointment/create", method = RequestMethod.GET)
		public ModelAndView customerCreateAppointment(Map<String, Object> model) {		
			ModelAndView mav = new ModelAndView("customer/appointment/create-appointment");
			Appointment appointment = new Appointment();
			model.put("appointment", appointment);
			return mav;
		}
		
		@RequestMapping(value = "/customer/appointment/create", method = RequestMethod.POST)
		public String customerCreateAppointment(@Valid Appointment appointment, BindingResult result, HttpServletRequest request) throws ParseException {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			MyUser myUser = (MyUser)authentication.getPrincipal();
			long userId = myUser.getUserId();
			User user = userService.find(userId);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
			//Appointment appointment = new Appointment();
			appointment.setUser(user);
			appointment.setName(request.getParameter("name"));
			appointment.setDate(format.parse(request.getParameter("date")));
			appointment.setDescription(request.getParameter("description"));
			appointmentService.save(appointment);

			return "redirect:/customer/appointment";
		}
		
		@RequestMapping(value = "/customer/appointment/delete/{id}", method = RequestMethod.GET)
		public String customerDeleteAppointment(@PathVariable("id") long id) {
			appointmentService.delete(id);
			return "redirect:/customer/appointment";
		}
}
