package com.pronix.spring.hms.doctor.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronix.spring.hms.doctor.models.DoctorDetailsData;
import com.pronix.spring.hms.doctor.models.DoctorProfile;
import com.pronix.spring.hms.doctor.models.StatusReport;
import com.pronix.spring.hms.doctor.pojos.AppointmentsList;
import com.pronix.spring.hms.doctor.pojos.DoctorDetails;
import com.pronix.spring.hms.doctor.pojos.LoginStatus;
import com.pronix.spring.hms.doctor.repositories.DoctorDetailsRepository;
import com.pronix.spring.hms.doctor.repositories.DoctorProfileRepository;
import com.pronix.spring.hms.patient.models.DoctorAppointments;
import com.pronix.spring.hms.patient.models.DoctorsList;
import com.pronix.spring.hms.patient.models.InpatientDetails;
import com.pronix.spring.hms.patient.models.PatientDetailsData;
import com.pronix.spring.hms.patient.models.PatientProfile;
import com.pronix.spring.hms.patient.pojos.DoctorVisits;
import com.pronix.spring.hms.patient.repositories.InpatientDetailsRepository;
import com.pronix.spring.hms.patient.repositories.PatientDetailsRepository;
import com.pronix.spring.hms.patient.repositories.PatientProfileRepository;
import com.pronix.spring.hms.patient.services.DoctorAppointmentsRepository;

@Service
public class DoctorDetailsService {

	@Autowired
	private DoctorDetailsRepository doctorDetailsRepository;
	
	@Autowired
	private DoctorProfileRepository doctorProfileRepository;
	
	@Autowired
	private DoctorAppointmentsRepository doctorAppointmentsRepository;
	
	@Autowired
	private PatientProfileRepository patientProfileRepository;
	
	@Autowired
	private PatientDetailsRepository patientDetailsRepository;
	
	@Autowired
	private InpatientDetailsRepository inpatientDetailsRepository;
	
	private List<DoctorDetailsData> currentDBUserList;
	
	public StatusReport registerUser(DoctorDetails registrationDetails) {
		currentDBUserList = checkMobileNumberOfDoctor(registrationDetails.getMobile());
		if(currentDBUserList.size() == 0) {
			long count = doctorDetailsRepository.count();
			String formatted = String.format("%08d", count+1);
			doctorDetailsRepository.save(new DoctorDetailsData("DR"+formatted,registrationDetails.getFullName(),
					registrationDetails.getEmailId(),registrationDetails.getMobile(),registrationDetails.getPassword()));
			return new StatusReport("success",000,"registered successfully");
		}else {
			return new StatusReport("failed",001,"Mobile Number already registered");
		}
	}
	
	public List<DoctorDetailsData> checkMobileNumberOfDoctor(String string) {
		return doctorDetailsRepository.findUserByMobile(string);
	}

	public LoginStatus loginUser(DoctorDetails loginCredentials) {
		LoginStatus loginStatus = null;
		currentDBUserList = checkMobileNumberOfDoctor(loginCredentials.getMobile());
		if(currentDBUserList.size() > 0) {
			for(DoctorDetailsData doctorDetailsData : currentDBUserList) {
				if(doctorDetailsData.getPassword().equals(loginCredentials.getPassword())) {
					loginStatus = new LoginStatus(new StatusReport("success",0000,""),doctorDetailsData);
				}else {
					loginStatus =  new LoginStatus(new StatusReport("failed",0003,"Wrong Password"),null);
				}
				break;
			}
		}else {
			loginStatus =  new LoginStatus(new StatusReport("failed",0002,"Mobile Number Not Registered"),null);
		}
		return loginStatus;
	}

	public StatusReport updateProfile(DoctorProfile updateProfileCredentials) {
		doctorProfileRepository.save(updateProfileCredentials);
		return new StatusReport("success",000,"Profile Updated Successfully");
	}

	public DoctorProfile viewProfile(String id) {
		return doctorProfileRepository.findOne(id);
	}

	public DoctorProfile viewProfileB(DoctorProfile updateProfileCredentials) {
		return doctorProfileRepository.findOne(updateProfileCredentials.getUserId());
	}

	public List<DoctorsList> doctorList(String specialization) {
		List<DoctorsList> doctorsList = new ArrayList<>();
		List<DoctorProfile> doctorProfileList =  doctorProfileRepository.findDoctorBySpecialization(specialization);
		for(DoctorProfile doctorProfile : doctorProfileList) {
			DoctorDetailsData doctorDetailsData = doctorDetailsRepository.findOne(doctorProfile.getUserId());
			doctorsList.add(new DoctorsList(doctorDetailsData.getFullName(),doctorDetailsData.getMobile(),doctorProfile));
		}
		return doctorsList;
	}

	public List<AppointmentsList> todayAppointments(String doctorId) throws ParseException {
		List<AppointmentsList> appointmentsListList = new ArrayList<>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(new Date());
		Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		List<DoctorAppointments> doctorAppointmentsList = 
				doctorAppointmentsRepository.findByDateAndDoctorId(date2,doctorId);
		System.out.println("date : "+dateFormat.format(new Date()));
		for(DoctorAppointments doctorAppointments:doctorAppointmentsList) {
			PatientProfile patientProfile = patientProfileRepository.findOne(doctorAppointments.getPatientId());
			PatientDetailsData patientDetailsData = patientDetailsRepository.findOne(doctorAppointments.getPatientId());
			appointmentsListList.add(new AppointmentsList(doctorAppointments.getAppointmentId(),doctorAppointments.getPatientId(),
					patientProfile.getFullName(),patientDetailsData.getMobile(),patientDetailsData.getEmailId(),patientProfile.getGender(),
					patientProfile.getAge(),patientProfile.getBloodGroup(),patientProfile.getAddress(),doctorAppointments.getPrescription(),
					doctorAppointments.getAppointment_status()));
		}
		return appointmentsListList;
	}

	public StatusReport updatePrescription(DoctorAppointments updatePrescription) {
		doctorAppointmentsRepository.updatePrescription(updatePrescription.getAppointmentId(),updatePrescription.getPrescription());
		return new StatusReport("success",000,"Prescription Updated Successfully");
	}

	public List<DoctorVisits> previousInterventions(DoctorAppointments previousInterventions) {
		List<DoctorVisits> doctorVisitsList = new ArrayList<>();
		List<DoctorAppointments> doctorAppointmentsList = 
				doctorAppointmentsRepository.fetchPreviousIntervention(previousInterventions.getDoctorId(),previousInterventions.getPatientId());
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

	public StatusReport escalateInpatient(String appointmentId) {
		doctorAppointmentsRepository.updateAppointmentStatus(appointmentId, "Escalate Inpatient");
		return new StatusReport("success",000,"Patient Successfully escalated as Inpatient");
	}
	
	public StatusReport closeAppointment(String appointmentId) {
		doctorAppointmentsRepository.updateAppointmentStatus(appointmentId, "close");
		return new StatusReport("success",000,"This appointment is Completed");
	}

	public List<InpatientDetails> ipList(String id) {
		return inpatientDetailsRepository.findIpByDoctorId(id);
	}

	public StatusReport updateDischargeDate(InpatientDetails dischargeDateUpdateObj) {
		inpatientDetailsRepository.updateDeliveryDate(dischargeDateUpdateObj.getInPatientId(),dischargeDateUpdateObj.getDischargeDate());
		return new StatusReport("success",000,"This Discharge Date is updated Sucessfully");
	}
	
	
	/*public List<DoctorVisits> patientHealthHistory(String patientId) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
