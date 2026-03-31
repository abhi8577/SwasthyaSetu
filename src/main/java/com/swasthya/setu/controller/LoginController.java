package com.swasthya.setu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swasthya.setu.response.Response;
import com.swasthya.setu.service.LoginService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login/{mobileNo}/{PatientOrDoctor}")
	private Response login(@PathVariable(name = "mobileNo") Long mobileNo,
			@PathVariable(name = "PatientOrDoctor") String PatientOrDoctor) {
		return loginService.login(mobileNo,PatientOrDoctor);
	}

}