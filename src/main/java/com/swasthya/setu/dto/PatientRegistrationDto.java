package com.swasthya.setu.dto;

import org.springframework.web.multipart.MultipartFile;

public class PatientRegistrationDto {

	private String fullName;
	private Long mobileNumber;
	private String email;
	private String gender;
	private String city;
	private String age;
	private MultipartFile profilePhoto;
	private String patientId;

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public MultipartFile getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(MultipartFile profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	@Override
	public String toString() {
		return "PatientRegistrationDto [fullName=" + fullName + ", mobileNumber=" + mobileNumber + ", email=" + email
				+ ", gender=" + gender + ", city=" + city + ", age=" + age + ", profilePhoto=" + profilePhoto
				+ ", patientId=" + patientId + ", getPatientId()=" + getPatientId() + ", getFullName()=" + getFullName()
				+ ", getMobileNumber()=" + getMobileNumber() + ", getEmail()=" + getEmail() + ", getGender()="
				+ getGender() + ", getCity()=" + getCity() + ", getAge()=" + getAge() + ", getProfilePhoto()="
				+ getProfilePhoto() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
