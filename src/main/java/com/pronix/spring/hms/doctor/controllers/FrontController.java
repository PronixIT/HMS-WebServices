package com.pronix.spring.hms.doctor.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pronix.spring.hms.doctor.models.DoctorProfile;
import com.pronix.spring.hms.doctor.models.StatusReport;
import com.pronix.spring.hms.doctor.pojos.AppointmentsList;
import com.pronix.spring.hms.doctor.pojos.DoctorDetails;
import com.pronix.spring.hms.doctor.pojos.LoginStatus;
import com.pronix.spring.hms.doctor.pojos.NextAppointment;
import com.pronix.spring.hms.doctor.services.DoctorDetailsService;
import com.pronix.spring.hms.patient.models.DoctorAppointments;
import com.pronix.spring.hms.patient.models.InpatientDetails;
import com.pronix.spring.hms.patient.pojos.DoctorVisits;
import com.pronix.spring.hms.patient.services.PatientDetailsService;


@RestController
@RequestMapping("/hms/doctor")
public class FrontController {
	
	@Autowired
	private DoctorDetailsService doctorDetailsService;
	
	@Autowired
	private PatientDetailsService patientDetailsService;

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public StatusReport registerUser(@RequestBody DoctorDetails registrationDetails){
		return doctorDetailsService.registerUser(registrationDetails);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public LoginStatus loginUser(@RequestBody DoctorDetails loginCredentials){
		return doctorDetailsService.loginUser(loginCredentials);
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
	
	@RequestMapping("/viewProfile/{id}")
	public DoctorProfile viewProfile(@PathVariable("id") String id){
		return doctorDetailsService.viewProfile(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/viewProfile")
	public DoctorProfile viewProfile(@RequestBody DoctorProfile updateProfileCredentials){
		return doctorDetailsService.viewProfileB(updateProfileCredentials);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateProfile")
	public StatusReport updateProfile(@RequestBody DoctorProfile updateProfileCredentials){
		return doctorDetailsService.updateProfile(updateProfileCredentials);
	}
	
	@RequestMapping("/todayAppointments/{id}")
	public List<AppointmentsList> todayAppointments(@PathVariable("id") String id) throws ParseException{
		return doctorDetailsService.todayAppointments(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updatePrescription")
	public StatusReport updatePrescription(@RequestBody DoctorAppointments updatePrescription){
		return doctorDetailsService.updatePrescription(updatePrescription);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/nextIntervention")
	public com.pronix.spring.hms.patient.pojos.StatusReport bookAppointment(@RequestBody NextAppointment NextAppointment){
		return patientDetailsService.bookAppointment(NextAppointment);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/previousInterventions")
	public List<DoctorVisits> previousInterventions(@RequestBody DoctorAppointments previousInterventions){
		return doctorDetailsService.previousInterventions(previousInterventions);
	}
	
	@RequestMapping("/patientHealthHistory/{id}")
	public List<DoctorVisits> patientHealthHistory(@PathVariable("id") String patientId){
		return patientDetailsService.patientAppointments(patientId);
	}
	
	@RequestMapping("/escalateInpatient/{id}")
	public StatusReport escalateInpatient(@PathVariable("id") String appointmentId){
		return doctorDetailsService.escalateInpatient(appointmentId);
	}
	
	@RequestMapping("/closeAppointment/{id}")
	public StatusReport closeAppointment(@PathVariable("id") String appointmentId){
		return doctorDetailsService.closeAppointment(appointmentId);
	}
	
	@RequestMapping("/ipList/{id}")
	public List<InpatientDetails> ipList(@PathVariable("id") String id) throws ParseException{
		return doctorDetailsService.ipList(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateDischargeDate")
	public StatusReport updateDischargeDate(@RequestBody InpatientDetails dischargeDateUpdateObj){
		return doctorDetailsService.updateDischargeDate(dischargeDateUpdateObj);
	}
	
}
