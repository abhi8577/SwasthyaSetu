package com.swasthya.setu.service;

import com.swasthya.setu.response.Response;

public interface LoginService {

	Response login(Long mobileNo, String patientOrDoctor);

}