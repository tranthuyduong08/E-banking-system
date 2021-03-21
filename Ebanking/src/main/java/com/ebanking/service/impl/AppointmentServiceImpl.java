package com.ebanking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.entity.Appointment;
import com.ebanking.repository.AppointmentRepository;
import com.ebanking.service.AppointmentService;

@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Override
	public Iterable<Appointment> findAll() {
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment find(long id) {
		return appointmentRepository.findOne(id);
	}

	@Override
	public void save(Appointment appointment) {
		appointmentRepository.save(appointment);
	}

	@Override
	public void delete(long id) {
		appointmentRepository.delete(id);
	}

}
