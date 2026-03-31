package com.swasthya.setu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swasthya.setu.dto.AppointmentDto;
import com.swasthya.setu.dto.PatientRegistrationDto;
import com.swasthya.setu.response.Response;
import com.swasthya.setu.service.PatientService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PutMapping(value = "/savePatientDetails", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Response patientRegistration(@ModelAttribute("dto") PatientRegistrationDto dto) {
		return patientService.patientRegistration(dto);

	}

	@PostMapping("/bookAppointment")
	public Response bookAppointmentDetails(@ModelAttribute("dto") AppointmentDto dto) {
		return patientService.bookAppointmentDetails(dto);

	}

}