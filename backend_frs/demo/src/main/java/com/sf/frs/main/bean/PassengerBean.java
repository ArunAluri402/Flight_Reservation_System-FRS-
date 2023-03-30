package com.sf.frs.main.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "FRS_TBL_Passenger")
public class PassengerBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int reservationID;
	@Column
	private String name;
	@Column
	private String gender;
	@Column
	private int age;
	@Column
	private int seatNo;
	public int getReservationID() {
		return reservationID;
	}
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public PassengerBean() {
		super();
	}
	
	
	
	

}



