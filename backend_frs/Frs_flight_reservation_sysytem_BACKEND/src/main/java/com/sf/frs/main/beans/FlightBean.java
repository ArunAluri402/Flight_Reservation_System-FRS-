package com.sf.frs.main.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FRS_TBL_FLIGHT")
public class FlightBean {
	
	public int getFlightID() {
		return flightID;
	}
	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public int getReservationCapacity() {
		return reservationCapacity;
	}
	public void setReservationCapacity(int reservationCapacity) {
		this.reservationCapacity = reservationCapacity;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int flightID;
	@Column
	private String flightName;
	@Column
	private int seatingCapacity;
	@Column
	private int reservationCapacity;
	public FlightBean(int flightID, String flightName, int seatingCapacity, int reservationCapacity) {
		this.flightID = flightID;
		this.flightName = flightName;
		this.seatingCapacity = seatingCapacity;
		this.reservationCapacity = reservationCapacity;
	}
	public FlightBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
