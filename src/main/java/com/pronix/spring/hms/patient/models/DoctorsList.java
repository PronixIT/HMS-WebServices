package com.pronix.spring.hms.patient.models;

import com.pronix.spring.hms.doctor.models.DoctorProfile;

public class DoctorsList {
	
	private String doctorName;
	private String doctorMobile;
	private DoctorProfile doctorProfile;
	
	public DoctorsList() {
		super();
	}

	public DoctorsList(String doctorName, String doctorMobile, DoctorProfile doctorProfile) {
		super();
		this.doctorName = doctorName;
		this.doctorMobile = doctorMobile;
		this.doctorProfile = doctorProfile;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorMobile() {
		return doctorMobile;
	}

	public void setDoctorMobile(String doctorMobile) {
		this.doctorMobile = doctorMobile;
	}

	public DoctorProfile getDoctorProfile() {
		return doctorProfile;
	}

	public void setDoctorProfile(DoctorProfile doctorProfile) {
		this.doctorProfile = doctorProfile;
	}

}
