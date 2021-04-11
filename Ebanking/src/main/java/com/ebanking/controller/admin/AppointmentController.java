package com.ebanking.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebanking.service.AppointmentService;

@Controller(value="appointmentControllerOfAdmin")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	// APPOINTMENT CONTROLLER
		@RequestMapping(value = "/admin/appointment", method = RequestMethod.GET)
		public ModelAndView adminViewAppointment(ModelMap modelMap) {
			modelMap.put("appointment", appointmentService.findAll());
			ModelAndView mav = new ModelAndView("admin/appointment/appointment-list");
			return mav;
		}
}
