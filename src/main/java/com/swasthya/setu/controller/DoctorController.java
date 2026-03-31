package com.swasthya.setu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swasthya.setu.dto.DocRemarkDto;
import com.swasthya.setu.response.Response;
import com.swasthya.setu.service.DocService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DoctorController {

	@Autowired
	private DocService docService;

	@PutMapping("/docRemark")
	public Response docRemark(@ModelAttribute("dto") DocRemarkDto dto) {
		return docService.docRemark(dto);

	}

	@GetMapping("/patientListByDate/{date}")
	public Response patientListByDate(@PathVariable("date") String date) {
		return docService.patientListByDate(date);

	}

	@GetMapping("/findAppointmentByStatus/{status}")
	public Response findAppointmentByStatus(@PathVariable("status") String status) {
		return docService.findAppointmentByStatus(status);

	}
}