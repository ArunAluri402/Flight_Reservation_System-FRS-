package com.sf.frs.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRS_TBL_USER_Credentials")
public class CredentialsBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int userID;
	@Column(nullable = false)
	private String password;
	@Column
	private String userType;
	@Column
	private int loginStatus;
	
//	getters and setters
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Integer getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}

//	constructors
	
	public CredentialsBean(int userID, String password, String userType, Integer loginStatus) {
		this.userID = userID;
		this.password = password;
		this.userType = userType;
		this.loginStatus = loginStatus;
	}
	
	public CredentialsBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
