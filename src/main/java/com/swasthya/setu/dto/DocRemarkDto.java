package com.swasthya.setu.dto;

import org.springframework.web.multipart.MultipartFile;

public class DocRemarkDto {

	private String drRemark;
	private String drId;
	private MultipartFile drFile;
	private String appointmentId;

	public String getDrRemark() {
		return drRemark;
	}

	public void setDrRemark(String drRemark) {
		this.drRemark = drRemark;
	}

	public String getDrId() {
		return drId;
	}

	public void setDrId(String drId) {
		this.drId = drId;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public MultipartFile getDrFile() {
		return drFile;
	}

	public void setDrFile(MultipartFile drFile) {
		this.drFile = drFile;
	}

}
