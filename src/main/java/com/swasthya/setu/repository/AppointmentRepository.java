package com.swasthya.setu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swasthya.setu.entity.AppointmentEntity;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

	public AppointmentEntity findByAppointmentId(String appointmentId);

	public List<AppointmentEntity> findByDate(String date);

	public List<AppointmentEntity> findByStatus(String status);
}
