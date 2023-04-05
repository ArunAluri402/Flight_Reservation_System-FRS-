package com.sf.frs.main.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.frs.main.bean.CredentialsBean;
import com.sf.frs.main.bean.FlightBean;
import com.sf.frs.main.bean.ProfileBean;
import com.sf.frs.main.bean.ReservationBean;
import com.sf.frs.main.bean.ScheduleBean;
import com.sf.frs.main.service.CredentialService;
import com.sf.frs.main.service.FlightService;
import com.sf.frs.main.service.ReservationService;
import com.sf.frs.main.service.ScheduleService;
import com.sf.frs.main.service.UserService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class FRSController {

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private CredentialService credentialService;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ScheduleService scheduleService;
	
//	flight controller

	@GetMapping("/flights")
	public List<FlightBean> getAllFlights() {
		return flightService.getAllFlights();
	}
	
	@GetMapping("flights/{flightId}")
	public FlightBean getFlightById(@PathVariable int flightId) {
		return flightService.getFlightById(flightId);
	}
	
	
//	Credential Controller

	
	@GetMapping("/credentials")
	public List<CredentialsBean> getgetAllCredentials() {
		return credentialService.getAllCredentials();
	}
	
//	Profile COntroller
	
	@GetMapping("/profiles")
	public List<ProfileBean> getAllProfiles() {
		return userservice.getAllProfile();
	}
	
	
//	Reservation Controller
	
	@GetMapping("/reservations")
	public List<ReservationBean> getAllReservations(){
		return reservationService.getAllReservations();
	}
	
//	Schedule Controller
	
	@GetMapping("/schedules")
	public List<ScheduleBean> getAllSchedules(){
		
		return scheduleService.getAllSchedules();
	}

}
