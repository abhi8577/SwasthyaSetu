package com.swasthya.setu.service;

import com.swasthya.setu.dto.DocRemarkDto;
import com.swasthya.setu.response.Response;

public interface DocService {

	Response docRemark(DocRemarkDto dto);

	Response patientListByDate(String date);

	Response findAppointmentByStatus(String status);

}
