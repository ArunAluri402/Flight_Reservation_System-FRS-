package com.sf.frs.main.bean;

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
	@JoinColumn(name = "userID")
	private CredentialsBean user;
	
	@ManyToOne
	@JoinColumn(name = "scheduleID")
	private ScheduleBean Schedule;
	
	

	public ReservationBean() {
		super();
	}
	
	
	
	

	public ScheduleBean getSchedule() {
		return Schedule;
	}



	public void setSchedule(ScheduleBean schedule) {
		Schedule = schedule;
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

	public CredentialsBean getUser() {
		return user;
	}

	public void setUser(CredentialsBean user) {
		this.user = user;
	}

}