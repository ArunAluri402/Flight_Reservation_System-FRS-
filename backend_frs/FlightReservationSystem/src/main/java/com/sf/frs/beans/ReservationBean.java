package com.sf.frs.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@JoinColumn(name = "userID",referencedColumnName = "userID")
	private CredentialsBean credentialsBean;
	
//	getters and setters

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

	public CredentialsBean getCredentialsBean() {
		return credentialsBean;
	}

	public void setCredentialsBean(CredentialsBean credentialsBean) {
		this.credentialsBean = credentialsBean;
	}

	public ReservationBean(int reservationID, String reservationType, String bookingDate, String journeyDate,
			int noOfSeats, double totalFare, int bookingStatus, CredentialsBean credentialsBean) {
		this.reservationID = reservationID;
		this.reservationType = reservationType;
		this.bookingDate = bookingDate;
		this.journeyDate = journeyDate;
		this.noOfSeats = noOfSeats;
		this.totalFare = totalFare;
		this.bookingStatus = bookingStatus;
		this.credentialsBean = credentialsBean;
	}

	public ReservationBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	

	
	
	
	

	
	
	
	
	
	
	

}
