package com.swasthya.setu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.swasthya.setu.entity.DoctorEntity;
import com.swasthya.setu.entity.PatientEntity;
import com.swasthya.setu.repository.DoctorRepository;
import com.swasthya.setu.repository.PatientRepository;
import com.swasthya.setu.response.Response;
import com.swasthya.setu.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Response login(Long mobileNo, String patientOrDoctor) {

		if (patientOrDoctor.equalsIgnoreCase("P")) {
			PatientEntity byMobileNumber = patientRepository.findByMobileNumber(mobileNo);
			if (byMobileNumber != null) {
				return Response.response("Patient Login Successfull", HttpStatus.OK, byMobileNumber);
			}
			return Response.response("Login Failed", HttpStatus.NOT_FOUND, null);

		} else if (patientOrDoctor.equalsIgnoreCase("D") ) {
			DoctorEntity byMobileNumber = doctorRepository.findByMobileNumber(mobileNo);
			if (byMobileNumber != null) {
				return Response.response("Doctor Login Successfull", HttpStatus.OK, byMobileNumber);
			}
			return Response.response("Login Failed", HttpStatus.NOT_FOUND, null);

		}
		return Response.response("Bad Request", HttpStatus.BAD_REQUEST, null);

	}

}