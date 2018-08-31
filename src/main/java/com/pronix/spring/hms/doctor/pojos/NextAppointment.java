package com.pronix.spring.hms.doctor.pojos;

public class NextAppointment {
	
	private String doctorId;
	private String patientId;
	private String date;
	
	public NextAppointment() {
		super();
	}

	public NextAppointment(String doctorId, String patientId, String date) {
		super();
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.date = date;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
