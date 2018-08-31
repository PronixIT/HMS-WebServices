package com.pronix.spring.hms.patient.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;

@Entity
@Table(name = "doctor_appointments")
public class DoctorAppointments implements Serializable{
	
	private static final long serialVersionUID = -4240231869126107450L;

	@Id
	private String appointmentId;
	
	@NotNull
	@Column(nullable = false)
	private String patientId;
	
	@NotNull
	@Column(nullable = false)
	private String doctorId;
	
	@NotNull
	@Column(nullable = false)
	private Date date;
	
	private String prescription;
	
	private String appointment_status;
	
	public String getAppointment_status() {
		return appointment_status;
	}

	public void setAppointment_status(String appointment_status) {
		this.appointment_status = appointment_status;
	}

	public DoctorAppointments() {
		super();
	}
	
	public DoctorAppointments(String appointmentId,String prescription) {
		super();
		this.appointmentId = appointmentId;
		this.prescription = prescription;
	}

	public DoctorAppointments(String patientId, String doctorId, Date date,String appointment_status) {
		super();
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.date = date;
		this.appointment_status = appointment_status;
	}

	public DoctorAppointments(String appointmentId, String patientId, String doctorId, Date date,String appointment_status) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.date = date;
		this.appointment_status = appointment_status;
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

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

}
