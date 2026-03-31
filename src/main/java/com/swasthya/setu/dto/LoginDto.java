package com.swasthya.setu.dto;

public class LoginDto {

	private Long mobileNo;
	private String patientOrDoctor;

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPatientOrDoctor() {
		return patientOrDoctor;
	}

	public void setPatientOrDoctor(String patientOrDoctor) {
		this.patientOrDoctor = patientOrDoctor;
	}
}