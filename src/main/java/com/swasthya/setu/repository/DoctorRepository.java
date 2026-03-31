package com.swasthya.setu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swasthya.setu.entity.DoctorEntity;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

	@Query(value = "SELECT * FROM SETU_DOCTOR_MASTER WHERE MOBILE_NUMBER=:mobileNumber", nativeQuery = true)
	DoctorEntity findByMobileNumber(@Param("mobileNumber") Long mobileNumber);
}