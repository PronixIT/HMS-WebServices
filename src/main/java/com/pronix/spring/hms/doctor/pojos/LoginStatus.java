package com.pronix.spring.hms.doctor.pojos;

import com.pronix.spring.hms.doctor.models.DoctorDetailsData;
import com.pronix.spring.hms.doctor.models.StatusReport;

public class LoginStatus {

	private StatusReport responseStatus;
	
	private DoctorDetailsData doctorDetailsData;

	public LoginStatus() {
		super();
	}

	public LoginStatus(StatusReport responseStatus, DoctorDetailsData doctorDetailsData) {
		super();
		this.responseStatus = responseStatus;
		this.doctorDetailsData = doctorDetailsData;
	}

	public StatusReport getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(StatusReport responseStatus) {
		this.responseStatus = responseStatus;
	}

	public DoctorDetailsData getDoctorDetailsData() {
		return doctorDetailsData;
	}

	public void setDoctorDetailsData(DoctorDetailsData doctorDetailsData) {
		this.doctorDetailsData = doctorDetailsData;
	}
	
}
