package com.sf.frs.main.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FRS_TBL_Reservation")
public class ReservationBean {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	@Column
	private int reservationID;
	
	@ManyToOne
	private CredentialsBean cb;
	
	@OneToMany(mappedBy = "rb", cascade = CascadeType.ALL)
    private List<PassengerBean> passenger;
	

	@ManyToOne
	private ScheduleBean sb;

	
	
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
	public int getReservationID() {
		return reservationID;
	}
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
	public CredentialsBean getCb() {
		return cb;
	}
	public void setCb(CredentialsBean cb) {
		this.cb = cb;
	}
	public List<PassengerBean> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<PassengerBean> passenger) {
		this.passenger = passenger;
	}
	public ScheduleBean getSb() {
		return sb;
	}
	public void setSb(ScheduleBean sb) {
		this.sb = sb;
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
	public ReservationBean() {
		super();
	}
	
	
	
}


