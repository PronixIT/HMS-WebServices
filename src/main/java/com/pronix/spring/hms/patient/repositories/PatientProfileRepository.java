package com.pronix.spring.hms.patient.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pronix.spring.hms.patient.models.PatientProfile;

@Repository
public interface PatientProfileRepository extends CrudRepository<PatientProfile, String>{

}