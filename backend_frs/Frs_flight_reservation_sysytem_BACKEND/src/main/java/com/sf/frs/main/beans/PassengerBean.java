package com.sf.frs.main.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FRS_TBL_PASSENGER")
public class PassengerBean {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String gender;
	@Column
	private int age;
	@Column
	private int seatNo;
	

	@ManyToOne(cascade = CascadeType.ALL)
	private ReservationBean reservationBean;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public ReservationBean getReservationBean() {
		return reservationBean;
	}


	public void setReservationBean(ReservationBean reservationBean) {
		this.reservationBean = reservationBean;
	}


	public PassengerBean(int id, String name, String gender, int age, int seatNo, ReservationBean reservationBean) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.seatNo = seatNo;
		this.reservationBean = reservationBean;
	}


	public PassengerBean() {
	
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
