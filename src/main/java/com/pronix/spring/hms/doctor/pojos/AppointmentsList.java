package com.pronix.spring.hms.doctor.pojos;

public class AppointmentsList {
	
	private String appointmentId;
	private String patientId;
	private String fullName;
	private String mobile;
	private String email;
	private String gender;
	private String age;
	private String bloodGroup;
	private String address;
	private String prescription;
	private String appointmentStatus;
	
	public AppointmentsList() {
		super();
	}

	public AppointmentsList(String appointmentId, String patientId, String fullName, String mobile, String email,
			String gender, String age, String bloodGroup, String address,String prescription, String appointmentStatus) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.fullName = fullName;
		this.mobile = mobile;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.bloodGroup = bloodGroup;
		this.address = address;
		this.prescription = prescription;
		this.appointmentStatus = appointmentStatus;
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	
	
	
}
