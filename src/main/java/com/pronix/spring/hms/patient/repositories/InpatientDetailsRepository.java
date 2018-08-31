package com.pronix.spring.hms.patient.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.pronix.spring.hms.patient.models.InpatientDetails;

public interface InpatientDetailsRepository  extends CrudRepository<InpatientDetails, String>{
	
	public static final String updateDeliveryDate = 
			"UPDATE inpatient_details SET discharge_date = ?2 WHERE in_patient_id = ?1";
	
	List<InpatientDetails> findIpByDoctorId(String id);
	
	@Transactional
    @Modifying
	@Query(value = updateDeliveryDate, nativeQuery = true)
	int updateDeliveryDate(String in_patient_id, Date discharge_date);

}
