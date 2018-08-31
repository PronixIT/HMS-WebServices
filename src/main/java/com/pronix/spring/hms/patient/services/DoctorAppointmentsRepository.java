package com.pronix.spring.hms.patient.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pronix.spring.hms.patient.models.DoctorAppointments;

@Repository
public interface DoctorAppointmentsRepository extends CrudRepository<DoctorAppointments, String>{
	
	public static final String updatePrescriptionQuery = 
			"UPDATE doctor_appointments SET prescription = ?2 WHERE appointment_id = ?1";
	
	public static final String updateAppointmentStatus = 
			"UPDATE doctor_appointments SET appointment_status = ?2 WHERE appointment_id = ?1";
	
	public static final String fetchPreviousInterventionQuery = 
			"select * from hms.doctor_appointments where patient_id=?2 and doctor_id = ?1 order by date desc";


	List<DoctorAppointments> findByDateAndDoctorId(Date date,String doctorId);

	List<DoctorAppointments> findByPatientIdOrderByDateDesc(String id);

	@Transactional
    @Modifying
	@Query(value = updatePrescriptionQuery, nativeQuery = true)
	int updatePrescription(String appointmentId, String prescription);
	
	@Query(value = fetchPreviousInterventionQuery, nativeQuery = true)
	List<DoctorAppointments> fetchPreviousIntervention(String doctorId, String patientId);

	//List<DoctorAppointments> findByPatientIdAndDoctorIdOrderByDateDesc(String doctorId, String patientId);
	
	
	@Transactional
    @Modifying
	@Query(value = updateAppointmentStatus, nativeQuery = true)
	int updateAppointmentStatus(String appointmentId, String appointment_status);
	
}
