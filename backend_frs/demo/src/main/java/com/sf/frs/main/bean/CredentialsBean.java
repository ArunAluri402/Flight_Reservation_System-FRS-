package com.sf.frs.main.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "FRS_TBL_User_Credentials")
public class CredentialsBean {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column
	private int userID;
	
	@OneToMany(mappedBy = "cb", cascade = CascadeType.ALL)
    private List<ProfileBean> profile;
	
	@OneToMany(mappedBy = "cb", cascade = CascadeType.ALL)
    private List<ReservationBean> rb;
	
	@Column
	private String password;
	
	@Column
	private String userType;
	
	public List<ReservationBean> getRb() {
		return rb;
	}

	public void setRb(List<ReservationBean> rb) {
		this.rb = rb;
	}

	@Column
	private String loginStatus;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public List<ProfileBean> getProfile() {
		return profile;
	}

	public void setProfile(List<ProfileBean> profile) {
		this.profile = profile;
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

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public CredentialsBean() {
		super();
	}


	
	

}
//userID String
//CredentialsBean password String
//userType String
//loginStatus