package com.sf.frs.main.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FRS_TBL_Schedule")
public class ScheduleBean {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column
	private int scheduleID;
	
	@Column
	private String availableDays;
	
	@Column
	private int travelDuration;
	
	@Column
	private String departureTime;
	
	@ManyToOne
	@JoinColumn(name = "routeID")
	private RouteBean route;

	
	@ManyToOne
	@JoinColumn(name = "flightID")
	private FlightBean Flight;

	
	public ScheduleBean() {
		super();
	}

	
	
	
	

	public RouteBean getRoute() {
		return route;
	}




	public void setRoute(RouteBean route) {
		this.route = route;
	}




	public FlightBean getFlight() {
		return Flight;
	}


	public void setFlight(FlightBean flight) {
		Flight = flight;
	}


	public int getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}

	public String getAvailableDays() {
		return availableDays;
	}

	public void setAvailableDays(String availableDays) {
		this.availableDays = availableDays;
	}

	public int getTravelDuration() {
		return travelDuration;
	}

	public void setTravelDuration(int travelDuration) {
		this.travelDuration = travelDuration;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	
	
	
	
	

}

