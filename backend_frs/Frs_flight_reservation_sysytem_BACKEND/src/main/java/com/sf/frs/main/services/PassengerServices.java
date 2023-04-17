package com.sf.frs.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.frs.main.beans.PassengerBean;
import com.sf.frs.main.dao.PassengerDAO;
import com.sf.frs.main.exceptions.DataNotFound;

@Service
public class PassengerServices {
	@Autowired
	private PassengerDAO passengerDAO;
	
	public List<PassengerBean> getAllPassengers(){
		return passengerDAO.findAll();	
		}
	
	public PassengerBean getPassengerByID(Integer id) {
		return passengerDAO.findById(id)
				.orElseThrow(()->new DataNotFound("Passenger not found"));
	}
	
	public PassengerBean createPassenger(PassengerBean passengerBean) {
		return passengerDAO.save(passengerBean);
	}
	
	

	  public void deletePassenger(Integer id){
	        PassengerBean passengerBean = passengerDAO.findById(id)
	            .orElseThrow(() -> new DataNotFound("Passenger : "+id+" not exists"));

	        passengerDAO.delete(passengerBean);
	    
}
}
