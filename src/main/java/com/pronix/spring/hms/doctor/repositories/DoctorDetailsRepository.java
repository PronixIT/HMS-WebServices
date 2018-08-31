package com.pronix.spring.hms.doctor.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pronix.spring.hms.doctor.models.DoctorDetailsData;

@Repository
public interface DoctorDetailsRepository extends CrudRepository<DoctorDetailsData, String>{

	List<DoctorDetailsData> findUserByMobile(String mobile);

}
