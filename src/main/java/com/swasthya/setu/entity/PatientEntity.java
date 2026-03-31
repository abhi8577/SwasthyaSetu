package com.swasthya.setu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SETU_PATIENT")
public class PatientEntity {

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ICICI_P_SEQ_GEN")
	@SequenceGenerator(name = "ICICI_P_SEQ_GEN", sequenceName = "ICICI_P_SEQ", allocationSize = 1)

	@Column(name = "ID")
	private Long id;

	@Column(name = "PATIENT_ID")
	private String patientId;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "MOBILE_NUMBER")
	private Long mobileNumber;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "CITY")
	private String city;

	@Column(name = "AGE")
	private String age;

	@Column(name = "PROFILE_PHOTO")
	private String profilePhoto;

	@Column(name = "CREATED_AT")
	private String createdAt;

	@Column(name = "CREATE_BY")
	private String createBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

}
