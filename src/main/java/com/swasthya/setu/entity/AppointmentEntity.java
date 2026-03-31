package com.swasthya.setu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SETU_APPOINTMENT")
public class AppointmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ICICI_A_SEQ_GEN")
	@SequenceGenerator(name = "ICICI_A_SEQ_GEN", sequenceName = "ICICI_A_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@Column(name = "APPOINTMENT_DATE")
	private String date;

	@Column(name = "TIME_SLOT")
	private String timeSlot;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "MOBILE_NUMBER")
	private Long mobileNumber;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "AGE")
	private String age;

	@Column(name = "STATUS")  
	private String status;

	@Column(name = "CREATED_AT")
	private String createdAt;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "DR_REMARK")
	private String drRemark;

	@Column(name = "OPD_FILE_PATH")
	private String opdFilePath;

	@Column(name = "DR_FILE_PATH")
	private String drFilePath;

	@Column(name = "DR_ID")
	private String drId;

	@Column(name = "DR_REMARK_TIME")
	private String drRemarkTime;

	@Column(name = "APPOINTMENT_ID")
	private String appointmentId;

	@Column(name = "PATIENT_ID")
	private String patientId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getDrRemark() {
		return drRemark;
	}

	public void setDrRemark(String drRemark) {
		this.drRemark = drRemark;
	}

	public String getOpdFilePath() {
		return opdFilePath;
	}

	public void setOpdFilePath(String opdFilePath) {
		this.opdFilePath = opdFilePath;
	}

	public String getDrFilePath() {
		return drFilePath;
	}

	public void setDrFilePath(String drFilePath) {
		this.drFilePath = drFilePath;
	}

	public String getDrId() {
		return drId;
	}

	public void setDrId(String drId) {
		this.drId = drId;
	}

	public String getDrRemarkTime() {
		return drRemarkTime;
	}

	public void setDrRemarkTime(String drRemarkTime) {
		this.drRemarkTime = drRemarkTime;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

}
