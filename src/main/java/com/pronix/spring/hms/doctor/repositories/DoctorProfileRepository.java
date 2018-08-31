package com.pronix.spring.hms.doctor.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pronix.spring.hms.doctor.models.DoctorProfile;

@Repository
public interface DoctorProfileRepository extends CrudRepository<DoctorProfile, String>{

	List<DoctorProfile> findDoctorBySpecialization(String specialization);

}
