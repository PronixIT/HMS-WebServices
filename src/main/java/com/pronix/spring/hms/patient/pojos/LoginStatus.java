package com.pronix.spring.hms.patient.pojos;

import com.pronix.spring.hms.patient.models.PatientDetailsData;

public class LoginStatus {
	
	private StatusReport responseStatus;
	
	private PatientDetailsData patientDetailsData;

	public LoginStatus() {
		super();
	}

	public LoginStatus(StatusReport responseStatus, PatientDetailsData patientDetailsData) {
		super();
		this.responseStatus = responseStatus;
		this.patientDetailsData = patientDetailsData;
	}

	public StatusReport getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(StatusReport responseStatus) {
		this.responseStatus = responseStatus;
	}

	public PatientDetailsData getPatientDetailsData() {
		return patientDetailsData;
	}

	public void setPatientDetailsData(PatientDetailsData patientDetailsData) {
		this.patientDetailsData = patientDetailsData;
	}
}
