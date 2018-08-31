package com.pronix.spring.hms.patient.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pronix.spring.hms.patient.models.PatientDetailsData;

@Repository
public interface PatientDetailsRepository extends CrudRepository<PatientDetailsData, String>{

	List<PatientDetailsData> findUserByMobile(String string);

}
