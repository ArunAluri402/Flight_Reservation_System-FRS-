package com.sf.frs.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FRS_TBL_ROUTE")
public class RouteBean {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int routeID;
	@Column
	private String source;
	@Column
	private String destination;
	@Column
	private int distance;
	@Column
	private double fare;
	public int getRouteID() {
		return routeID;
	}
	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public RouteBean(int routeID, String source, String destination, int distance, double fare) {
		this.routeID = routeID;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.fare = fare;
	}
	public RouteBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
