package com.swasthya.setu.dto;

import org.springframework.web.multipart.MultipartFile;

public class AppointmentDto {

	private String date;
	private String timeSlot;
	private String fullName;
	private Long mobileNumber;
	private String gender;
	private String age;
	private MultipartFile opdFile;
	private String patientId;
	

	public MultipartFile getOpdFile() {
		return opdFile;
	}

	public void setOpdFile(MultipartFile opdFile) {
		this.opdFile = opdFile;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

}
