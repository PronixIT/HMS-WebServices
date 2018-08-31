package com.pronix.spring.hms.patient.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "patient_details_data")
public class PatientDetailsData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8216857778152135075L;

	@Id
	private String userId;
	
	@NotNull
	@Column(nullable = false)
	private String fullName;
	
	@NotNull
	@Column(nullable = false)
	private String emailId;
	
	@NotNull
	@Column(nullable = false)
	private String mobile;
	
	@NotNull
	@Column(nullable = false)
	private String password;

	public PatientDetailsData() {
		super();
	}

	public PatientDetailsData(String userId, String fullName, String emailId, String mobile, String password) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.mobile = mobile;
		this.password = password;
	}
	
	public void setuserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}