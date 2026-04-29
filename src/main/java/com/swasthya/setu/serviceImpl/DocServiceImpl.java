package com.swasthya.setu.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.swasthya.setu.dto.DocRemarkDto;
import com.swasthya.setu.dto.DoctorDto;
import com.swasthya.setu.dto.FileUploadPathDto;
import com.swasthya.setu.entity.AppointmentEntity;
import com.swasthya.setu.entity.DoctorEntity;
import com.swasthya.setu.entity.PatientEntity;
import com.swasthya.setu.repository.AppointmentRepository;
import com.swasthya.setu.repository.DoctorRepository;
import com.swasthya.setu.response.Response;
import com.swasthya.setu.service.DocService;
import com.swasthya.setu.utility.Utility;

@Service
public class DocServiceImpl implements DocService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public Response docRemark(DocRemarkDto dto) {
		Response documentFile1;

		AppointmentEntity byAppointmentId = appointmentRepository.findByAppointmentId(dto.getAppointmentId());
		if (byAppointmentId == null) {
			return Response.response("Appointment Not Found", HttpStatus.NOT_FOUND, null);
		}
		byAppointmentId.setDrRemark(dto.getDrRemark());
		byAppointmentId.setDrId(dto.getDrId());
		byAppointmentId.setStatus(dto.getStatus());
		byAppointmentId.setDrRemarkTime(LocalDateTime.now().toString());
		byAppointmentId.setDrFileType(dto.getDocType());

		try {
			documentFile1 = Utility.uploadFile(dto.getDrFile(), byAppointmentId.getAppointmentId() + "-DRREMARK_PHOTO",
					"dr_remark\\");

			if (documentFile1.getStatusCode() == 200) {

				FileUploadPathDto fileUploadPathDto = (FileUploadPathDto) documentFile1.getResponse();

				byAppointmentId.setDrFilePath(fileUploadPathDto.getFilePath());

			} else {

				return documentFile1;

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AppointmentEntity save = appointmentRepository.save(byAppointmentId);
		return Response.response("Dr Remark Added", HttpStatus.OK, save);

	}

	@Override
	public Response patientListByDate(String date) {

		List<AppointmentEntity> byDate = appointmentRepository.findByDate(date);

		if (byDate != null && !byDate.isEmpty()) {
			return Response.response("Data Fetched Successfully", HttpStatus.OK, byDate);

		}
		return Response.response("Data Not Available For This Date", HttpStatus.NOT_FOUND, null);

	}

	@Override
	public Response findAppointmentByStatus(String status) {

		List<AppointmentEntity> appointments;

		if ("TOTAL".equalsIgnoreCase(status.trim())) {
			// Sab data lao
			appointments = appointmentRepository.findAll();
		} else {
			// Normal status filter
			appointments = appointmentRepository.findByStatusOrderByCreatedAtDesc(status);
		}

		if (appointments != null && !appointments.isEmpty()) {
			return Response.response("Data Fetched Successfully", HttpStatus.OK, appointments);
		}

		return Response.response("Data Not Available For This Status", HttpStatus.NOT_FOUND, null);
	}

	@Override
	public Response findAllDoctorList() {

		List<DoctorEntity> all = doctorRepository.findAll();

		return Response.response("Data Fetched Successfully", HttpStatus.OK, all);
	}

	public Response createDoctor(DoctorDto dto) {

		try {
			
			DoctorEntity byMobileNumber = doctorRepository.findByMobileNumber(dto.getMobileNumber());
			// agar update hai aur same patient hai → allow
			if (byMobileNumber != null) {
				return Response.response("Mobile Number Already Exist", HttpStatus.CONFLICT, null);
			}

			DoctorEntity doctor = new DoctorEntity();

			// ✅ set basic fields
			doctor.setDoctorName(dto.getDoctorName());
			doctor.setGender(dto.getGender());
			doctor.setAge(dto.getAge());
			doctor.setMobileNumber(dto.getMobileNumber());
			doctor.setEmailId(dto.getEmailId());
			doctor.setSpecialization(dto.getSpecialization());
			doctor.setQualification(dto.getQualification());
			doctor.setExperienceYears(dto.getExperienceYears());
			doctor.setConsultationFee(dto.getConsultationFee());
			doctor.setClinicName(dto.getClinicName());
			doctor.setClinicAddress(dto.getClinicAddress());
			doctor.setCreatedBy(dto.getDoctorName());
			doctor.setCreatedAt(LocalDateTime.now().toString());
			doctor.setUpdatedAt(LocalDateTime.now().toString());

			// ✅ IMAGE UPLOAD LOGIC (your code)
			if (dto.getDrFile() != null && !dto.getDrFile().isEmpty()) {

				Response documentFile = Utility.uploadFile(dto.getDrFile(), dto.getDoctorName() + "-DR_IMAGE",
						"doctor\\");

				if (documentFile.getStatusCode() == 200) {

					FileUploadPathDto fileUploadPathDto = (FileUploadPathDto) documentFile.getResponse();

					doctor.setDrImagePath(fileUploadPathDto.getFilePath());

				} else {
					return documentFile;
				}
			}

			// ✅ SAVE
			DoctorEntity savedDoctor = doctorRepository.save(doctor);

			return Response.response("Doctor created successfully", HttpStatus.CREATED, savedDoctor);

		} catch (Exception e) {
			e.printStackTrace();

			return Response.response("Failed to create doctor", HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
}