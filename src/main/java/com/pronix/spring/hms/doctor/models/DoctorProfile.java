package com.pronix.spring.hms.doctor.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;

@Entity
@Table(name = "doctor_profile")
public class DoctorProfile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3307619271846980824L;
	
	@Id
	private String userId;
	
	@NotNull
	@Column(nullable = false)
	private String fullName;
	
	@NotNull
	@Column(nullable = false)
	private String hospitalName;
	
	@NotNull
	@Column(nullable = false)
	private String specialization;
	
	@NotNull
	@Column(nullable = false)
	private String exp;
	
	@NotNull
	@Column(nullable = false)
	private String qualification;
	
	@NotNull
	@Column(nullable = false)
	private String timings;
	
	@NotNull
	@Column(nullable = false)
	private String consultationFee;

	public DoctorProfile() {
		super();
	}

	public DoctorProfile(String userId) {
		super();
		this.userId = userId;
	}

	public DoctorProfile(String userId, String fullName, String hospitalName, String specialization, String exp, String qualification,
			String timings, String consultationFee) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.hospitalName = hospitalName;
		this.specialization = specialization;
		this.exp = exp;
		this.qualification = qualification;
		this.timings = timings;
		this.consultationFee = consultationFee;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public String getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(String consultationFee) {
		this.consultationFee = consultationFee;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
