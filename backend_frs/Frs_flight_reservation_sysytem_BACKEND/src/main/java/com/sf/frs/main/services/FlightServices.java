package com.sf.frs.main.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.frs.main.beans.FlightBean;
import com.sf.frs.main.dao.FlightDAO;
import com.sf.frs.main.exceptions.DataNotFound;

@Service
public class FlightServices {
	
	@Autowired
	private FlightDAO flightDAO;
	
	  @Transactional
	    public FlightBean saveFlight(FlightBean flight) {
	        return flightDAO.save(flight);
	    }
	
	  public List<FlightBean> getAllFlights(){
	        return flightDAO.findAll();
	    }

	  public FlightBean getFlightById(Integer id){
	        return flightDAO.findById(id)
	            .orElseThrow(() -> new DataNotFound("Flight with id : "+id+" not exists"));
	    }
	  
	  public FlightBean createFlight(FlightBean flight){
	        return flightDAO.save(flight);
	    }

	  
	  public void deleteflight(Integer id){
	        FlightBean flightBean = flightDAO.findById(id)
	            .orElseThrow(() -> new DataNotFound("Flight with id : "+id+" not exists"));

	        flightDAO.delete(flightBean);
	    }

	public FlightBean updateFlight(Integer id, FlightBean flight) {
		FlightBean flightbean = flightDAO.findById(id)
	            .orElseThrow(() -> new DataNotFound("Flight with id : "+id+" not exists"));

	       flightbean.setFlightName(flight.getFlightName());
	       flightbean.setReservationCapacity(flight.getReservationCapacity());
	       flightbean.setSeatingCapacity(flight.getSeatingCapacity());
	       
	       return flightDAO.save(flightbean);

	       
	}

}
