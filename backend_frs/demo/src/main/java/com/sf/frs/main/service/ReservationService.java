package com.sf.frs.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.frs.main.bean.ReservationBean;
import com.sf.frs.main.dao.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationrepository;
	
	public List<ReservationBean> getAllReservations() {
		return reservationrepository.findAll();
	}
	


}
