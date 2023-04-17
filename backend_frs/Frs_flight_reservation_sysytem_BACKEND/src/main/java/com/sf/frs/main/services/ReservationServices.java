package com.sf.frs.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.frs.main.beans.ReservationBean;
import com.sf.frs.main.dao.ReservationDAO;
import com.sf.frs.main.exceptions.DataNotFound;

@Service
public class ReservationServices {

	@Autowired
	private ReservationDAO reservationDAO;
	
	public List<ReservationBean> getallReservations(){
		return reservationDAO.findAll();
	}
	
	public ReservationBean getReservationById(Integer id){
        return reservationDAO.findById(id)
            .orElseThrow(() -> new DataNotFound("Reservation with id : "+id+" not exists"));
    }
  
  public ReservationBean createReservation(ReservationBean reservationBean){
        return reservationDAO.save(reservationBean);
    }

  
  public void deleteReservation(Integer id){
        ReservationBean reservationBean = reservationDAO.findById(id)
            .orElseThrow(() -> new DataNotFound("Reservation with id : "+id+" not exists"));

        reservationDAO.delete(reservationBean);
    }
}
