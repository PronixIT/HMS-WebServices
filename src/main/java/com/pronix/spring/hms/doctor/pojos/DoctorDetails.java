package com.pronix.spring.hms.doctor.pojos;

public class DoctorDetails {
	
	private String fullName;
	private String emailId;
	private String mobile;
	private String password;
	
	public DoctorDetails() {
		super();
	}

	public DoctorDetails(String fullName, String emailId, String mobile, String password) {
		super();
		this.fullName = fullName;
		this.emailId = emailId;
		this.mobile = mobile;
		this.password = password;
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
