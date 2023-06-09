package com.sf.frs.main.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FRS_TBL_SCHEDULE")
public class ScheduleBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int scheduleID;
	@Column
	private int travelduration;
	@Column
	private String availableDays;
	@Column
	private String departureTime;

	@ManyToOne
	private FlightBean flightBean;

	@ManyToOne
	private RouteBean routeBean;

	
	public int getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}

	public int getTravelduration() {
		return travelduration;
	}

	public void setTravelduration(int travelduration) {
		this.travelduration = travelduration;
	}

	public String getAvailableDays() {
		return availableDays;
	}

	public void setAvailableDays(String availableDays) {
		this.availableDays = availableDays;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public FlightBean getFlightBean() {
		return flightBean;
	}

	public void setFlightBean(FlightBean flightBean) {
		this.flightBean = flightBean;
	}

	public RouteBean getRouteBean() {
		return routeBean;
	}

	public void setRouteBean(RouteBean routeBean) {
		this.routeBean = routeBean;
	}



	public ScheduleBean(int scheduleID, int travelduration, String availableDays, String departureTime,
			FlightBean flightBean, RouteBean routeBean, List<ReservationBean> reservationBeans) {
		super();
		this.scheduleID = scheduleID;
		this.travelduration = travelduration;
		this.availableDays = availableDays;
		this.departureTime = departureTime;
		this.flightBean = flightBean;
		this.routeBean = routeBean;
		
	}

	public ScheduleBean() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	

}
