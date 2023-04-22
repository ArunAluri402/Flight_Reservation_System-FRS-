package com.sf.frs.main.beans;

import java.util.ArrayList;
import java.util.Collection;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "FRS_TBL_Reservation")
public class ReservationBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int reservationID;
	@Column
	private String reservationType;
	@Column
	private String bookingDate;
	@Column
	private String journeyDate;
	@Column
	private int noOfSeats;
	@Column
	private double totalFare;
	@Column
	private int bookingStatus;

	@ManyToOne
	private User user;



	@ManyToOne
	private ScheduleBean scheduleBean;

	@OneToMany(mappedBy = "reservationBean", cascade = CascadeType.ALL)
	@JsonBackReference
	private Collection<PassengerBean> passengerBeans = new ArrayList<PassengerBean>();
	
	public Collection<PassengerBean> getPassengerBeans() {
		return passengerBeans;
	}

	public void setPassengerBeans(Collection<PassengerBean> passengerBeans) {
		this.passengerBeans = passengerBeans;
	}
	

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public int getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ScheduleBean getScheduleBean() {
		return scheduleBean;
	}

	public void setScheduleBean(ScheduleBean scheduleBean) {
		this.scheduleBean = scheduleBean;
	}




	public ReservationBean() {
	
		// TODO Auto-generated constructor stub
	}

	public ReservationBean(int reservationID, String reservationType, String bookingDate, String journeyDate,
			int noOfSeats, double totalFare, int bookingStatus, User user, ScheduleBean scheduleBean,
			Collection<PassengerBean> passengerBeans) {
		super();
		this.reservationID = reservationID;
		this.reservationType = reservationType;
		this.bookingDate = bookingDate;
		this.journeyDate = journeyDate;
		this.noOfSeats = noOfSeats;
		this.totalFare = totalFare;
		this.bookingStatus = bookingStatus;
		this.user = user;
		this.scheduleBean = scheduleBean;
		this.passengerBeans = passengerBeans;
	}

	
}
