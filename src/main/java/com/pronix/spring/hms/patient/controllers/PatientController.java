package com.pronix.spring.hms.patient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pronix.spring.hms.doctor.pojos.NextAppointment;
import com.pronix.spring.hms.doctor.services.DoctorDetailsService;
import com.pronix.spring.hms.patient.models.DoctorAppointments;
import com.pronix.spring.hms.patient.models.DoctorsList;
import com.pronix.spring.hms.patient.models.PatientProfile;
import com.pronix.spring.hms.patient.pojos.DoctorVisits;
import com.pronix.spring.hms.patient.pojos.LoginStatus;
import com.pronix.spring.hms.patient.pojos.PatientDetails;
import com.pronix.spring.hms.patient.pojos.StatusReport;
import com.pronix.spring.hms.patient.services.PatientDetailsService;

@RestController
@RequestMapping("/hms/patient")
public class PatientController {
	
	@Autowired
	private PatientDetailsService patientDetailsService;
	
	@Autowired
	private DoctorDetailsService doctorDetailsService;

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public StatusReport registerUser(@RequestBody PatientDetails registrationDetails){
		return patientDetailsService.registerUser(registrationDetails);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public LoginStatus loginUser(@RequestBody PatientDetails loginCredentials){
		return patientDetailsService.loginUser(loginCredentials);
	}
	
	/*@RequestMapping(method = RequestMethod.POST, value = "/changePassword")
	public ResponseStatus changePassword(@RequestBody UserDetails changePasswordCredentials){
		return userDetailsService.changePassword(changePasswordCredentials);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/forgotPassword")
	public ResponseStatus forgotPassword(@RequestBody UserDetails forgotPasswordCredentials){
		return userDetailsService.forgotPassword(forgotPasswordCredentials);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updatePassword")
	public ResponseStatus updatePassword(@RequestBody UserDetails updatePasswordCredentials){
		return userDetailsService.updatePassword(updatePasswordCredentials);
	}*/
	
	@RequestMapping(method = RequestMethod.POST, value = "/viewProfile")
	public PatientProfile viewProfile(@RequestBody PatientProfile viewProfileCredentials){
		return patientDetailsService.viewProfile(viewProfileCredentials);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateProfile")
	public StatusReport updateProfile(@RequestBody PatientProfile updateProfileCredentials){
		return patientDetailsService.updateProfile(updateProfileCredentials);
	}
	
	@RequestMapping("/doctorLookup/{specialization}")
	public List<DoctorsList> doctorList(@PathVariable("specialization") String specialization){
		return doctorDetailsService.doctorList(specialization);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/bookAppointment")
	public StatusReport bookAppointment(@RequestBody NextAppointment doctorAppointments){
		return patientDetailsService.bookAppointment(doctorAppointments);
	}
	
	@RequestMapping("/myAppointments/{id}")
	public List<DoctorVisits> myAppointments(@PathVariable("id") String id){
		return patientDetailsService.patientAppointments(id);
	}
}
