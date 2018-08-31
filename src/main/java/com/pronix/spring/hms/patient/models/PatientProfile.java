package com.pronix.spring.hms.patient.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "patient_profile")
public class PatientProfile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7172289276409952308L;
	
	@Id
	private String userId;
	
	@NotNull
	@Column(nullable = false)
	private String fullName;
	
	@NotNull
	@Column(nullable = false)
	private String gender;
	
	@NotNull
	@Column(nullable = false)
	private String age;
	
	@NotNull
	@Column(nullable = false)
	private String bloodGroup;
	
	@NotNull
	@Column(nullable = false)
	private String address;

	public PatientProfile() {
		super();
	}

	public PatientProfile(String userId) {
		super();
		this.userId = userId;
	}

	public PatientProfile(String userId, String fullName, String gender, String age, String bloodGroup, String address) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.gender = gender;
		this.age = age;
		this.bloodGroup = bloodGroup;
		this.address = address;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
