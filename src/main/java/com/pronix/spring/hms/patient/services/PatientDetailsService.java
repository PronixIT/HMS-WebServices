package com.pronix.spring.hms.patient.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronix.spring.hms.doctor.models.DoctorProfile;
import com.pronix.spring.hms.doctor.pojos.NextAppointment;
import com.pronix.spring.hms.doctor.repositories.DoctorProfileRepository;
import com.pronix.spring.hms.patient.models.DoctorAppointments;
import com.pronix.spring.hms.patient.models.PatientDetailsData;
import com.pronix.spring.hms.patient.models.PatientProfile;
import com.pronix.spring.hms.patient.pojos.DoctorVisits;
import com.pronix.spring.hms.patient.pojos.LoginStatus;
import com.pronix.spring.hms.patient.pojos.PatientDetails;
import com.pronix.spring.hms.patient.pojos.StatusReport;
import com.pronix.spring.hms.patient.repositories.PatientDetailsRepository;
import com.pronix.spring.hms.patient.repositories.PatientProfileRepository;

@Service
public class PatientDetailsService {

	@Autowired
	private PatientDetailsRepository patientDetailsRepository;
	
	@Autowired
	private PatientProfileRepository patientProfileRepository;
	
	@Autowired
	private DoctorProfileRepository doctorProfileRepository;
	
	@Autowired
	private DoctorAppointmentsRepository doctorAppointmentsRepository;
	
	private List<PatientDetailsData> currentDBUserList;
	
	public StatusReport registerUser(PatientDetails registrationDetails) {
		currentDBUserList = checkMobileNumberOfPatient(registrationDetails.getMobile());
		if(currentDBUserList.size() == 0) {
			long count = patientDetailsRepository.count();
			String formatted = String.format("%08d", count+1);
			patientDetailsRepository.save(new PatientDetailsData("PT"+formatted,registrationDetails.getFullName(),
					registrationDetails.getEmailId(),registrationDetails.getMobile(),registrationDetails.getPassword()));
			return new StatusReport("success",000,"registered successfully");
		}else {
			return new StatusReport("failed",001,"Mobile Number already registered");
		}
	}
	
	public List<PatientDetailsData> checkMobileNumberOfPatient(String string) {
		return patientDetailsRepository.findUserByMobile(string);
	}

	public LoginStatus loginUser(PatientDetails loginCredentials) {
		LoginStatus loginStatus = null;
		currentDBUserList = checkMobileNumberOfPatient(loginCredentials.getMobile());
		if(currentDBUserList.size() > 0) {
			for(PatientDetailsData PatientDetailsData : currentDBUserList) {
				if(PatientDetailsData.getPassword().equals(loginCredentials.getPassword())) {
					loginStatus = new LoginStatus(new StatusReport("success",0000,""),PatientDetailsData);
				}else {
					loginStatus = new LoginStatus(new StatusReport("failed",0003,"Wrong Password"),null);
				}
				break;
			}
		}else {
			loginStatus = new LoginStatus(new StatusReport("failed",002,"Mobile Number Not Registered"),null);
		}
		return loginStatus;
	}

	public PatientProfile viewProfile(PatientProfile viewProfileCredentials) {
		return patientProfileRepository.findOne(viewProfileCredentials.getUserId());
	}

	public StatusReport updateProfile(PatientProfile updateProfileCredentials) {
		patientProfileRepository.save(updateProfileCredentials);
		return new StatusReport("success",000,"Profile Updated Successfully");
	}

	public StatusReport bookAppointment(NextAppointment nextAppointment) {
		String date = nextAppointment.getDate();
		Date date2 = null;
		try {
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long count = doctorAppointmentsRepository.count();
		String formatted = String.format("%08d", count+1);
		doctorAppointmentsRepository.save(new DoctorAppointments("DAB"+formatted,
				nextAppointment.getPatientId(),nextAppointment.getDoctorId(), date2, "open"));
		return new StatusReport("success",000,"Profile Updated Successfully");
	}

	public List<DoctorVisits> patientAppointments(String id) {
		//System.out.println("id : "+id);
		List<DoctorVisits> doctorVisitsList = new ArrayList<>();
		List<DoctorAppointments> doctorAppointmentsList = doctorAppointmentsRepository.findByPatientIdOrderByDateDesc(id);
		//System.out.println("doctorAppointmentsList : "+doctorAppointmentsList);
		for(DoctorAppointments doctorAppointments:doctorAppointmentsList) {
			DoctorProfile doctorProfile = doctorProfileRepository.findOne(doctorAppointments.getDoctorId());
			doctorVisitsList.add(new DoctorVisits(doctorAppointments.getDate().toString(),doctorProfile.getFullName(),
					doctorProfile.getHospitalName(),doctorProfile.getSpecialization(),doctorProfile.getExp(),
					doctorProfile.getQualification(),doctorProfile.getTimings(),doctorProfile.getConsultationFee(),
					doctorAppointments.getPrescription()));
		}
		return doctorVisitsList;
	}
	
}
