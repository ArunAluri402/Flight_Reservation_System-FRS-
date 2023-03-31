package com.sf.frs.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.frs.main.bean.FlightBean;
import com.sf.frs.main.dao.FlightRepository;
import com.sf.frs.main.exceptions.ErrorExceptions;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightrepo;
	
	public List<FlightBean> getAllFlights() {
		return flightrepo.findAll();
	}
	
	public FlightBean getFlightById(int flightId) {
		Optional<FlightBean> optionalFlight = flightrepo.findById(flightId);
		if (optionalFlight.isPresent()) {
			return optionalFlight.get();
		} else {
			throw new ErrorExceptions("Flight", "flightId", flightId);
		}
	}

}
