package com.ebanking.service;

import com.ebanking.entity.Appointment;

public interface AppointmentService {
	public Iterable<Appointment> findAll();
	
	public Appointment find(long id);
	
	public void save(Appointment appointment);

	public void delete(long id);
}
