package com.pronix.spring.hms.patient.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "inpatient_details")
public class InpatientDetails  implements Serializable{

	private static final long serialVersionUID = -4381998737481315431L;

	@Id
	private String inPatientId;
	
	@NotNull
	@Column(nullable = false)
	private String patientId;
	
	@NotNull
	@Column(nullable = false)
	private String doctorId;
	
	private String hospitalId;
	
	@NotNull
	@Column(nullable = false)
	private String roomNo;
	
	@NotNull
	@Column(nullable = false)
	private String bedNo;
	
	private Date dischargeDate;
	
	public InpatientDetails() {
		// TODO Auto-generated constructor stub
	}

	public InpatientDetails(String inPatientId,String patientId, String doctorId, String hospitalId, String roomNo, String bedNo) {
		super();
		this.inPatientId = inPatientId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.hospitalId = hospitalId;
		this.roomNo = roomNo;
		this.bedNo = bedNo;
	}
	
	public InpatientDetails(String inPatientId, Date dischargeDate) {
		super();
		this.inPatientId = inPatientId;
		this.dischargeDate = dischargeDate;
	}

	public String getInPatientId() {
		return inPatientId;
	}

	public void setInPatientId(String inPatientId) {
		this.inPatientId = inPatientId;
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

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
}
