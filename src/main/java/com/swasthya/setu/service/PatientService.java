package com.swasthya.setu.service;

import com.swasthya.setu.dto.AppointmentDto;
import com.swasthya.setu.dto.PatientRegistrationDto;
import com.swasthya.setu.response.Response;

public interface PatientService {

	Response patientRegistration(PatientRegistrationDto dto);

	Response bookAppointmentDetails(AppointmentDto dto);

}
