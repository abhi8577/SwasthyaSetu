package com.swasthya.setu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swasthya.setu.entity.PatientEntity;

@Repository
public interface PatientRepository  extends JpaRepository<PatientEntity, Long>{
	
	Optional<PatientEntity> findByPatientId(String patientId);

	PatientEntity findByMobileNumber(Long mobileNo);
	

}
