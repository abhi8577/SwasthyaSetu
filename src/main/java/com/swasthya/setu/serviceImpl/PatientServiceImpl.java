package com.swasthya.setu.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.swasthya.setu.dto.AppointmentDto;
import com.swasthya.setu.dto.FileUploadPathDto;
import com.swasthya.setu.dto.PatientRegistrationDto;
import com.swasthya.setu.entity.AppointmentEntity;
import com.swasthya.setu.entity.PatientEntity;
import com.swasthya.setu.repository.AppointmentRepository;
import com.swasthya.setu.repository.PatientRepository;
import com.swasthya.setu.response.Response;
import com.swasthya.setu.service.PatientService;
import com.swasthya.setu.utility.Utility;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public Response patientRegistration(PatientRegistrationDto dto) {

		PatientEntity byMobileNumber = patientRepository.findByMobileNumber(dto.getMobileNumber());
		if (byMobileNumber != null) {
			return Response.response("Mobile Number Already Exist", HttpStatus.CONFLICT, null);
		}

		PatientEntity patientEntity;

		Optional<PatientEntity> byPatientId = patientRepository.findByPatientId(dto.getPatientId());
		if (byPatientId.isPresent()) {
			patientEntity = byPatientId.get();
		} else {
			patientEntity = new PatientEntity();
			patientEntity.setPatientId(Utility.generateUniqueNumber());
		}

		patientEntity.setAge(dto.getAge());
		patientEntity.setCity(dto.getCity());
		patientEntity.setEmail(dto.getEmail());
		patientEntity.setFullName(dto.getFullName());
		patientEntity.setGender(dto.getGender());
		patientEntity.setMobileNumber(dto.getMobileNumber());
		patientEntity.setCreatedAt(LocalDateTime.now().toString());
		patientEntity.setCreateBy(dto.getFullName());
		Response documentFile1;
		try {
			documentFile1 = Utility.uploadFile(dto.getProfilePhoto(), patientEntity.getPatientId() + "-PROFILE_PHOTO",
					"setu_profile_photo\\");

			if (documentFile1.getStatusCode() == 200) {

				FileUploadPathDto fileUploadPathDto = (FileUploadPathDto) documentFile1.getResponse();

				patientEntity.setProfilePhoto(fileUploadPathDto.getFilePath());

			} else {

				return documentFile1;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		PatientEntity save = patientRepository.save(patientEntity);
		return Response.response("Patient Details Has Been Created", HttpStatus.OK, save);

	}

	@Override
	public Response bookAppointmentDetails(AppointmentDto dto) {
		if (dto != null) {

			AppointmentEntity appointmentEntity = new AppointmentEntity();
			appointmentEntity.setStatus("PENDING");
			appointmentEntity.setAppointmentId(Utility.generateAppointmentNumber());
			appointmentEntity.setAge(dto.getAge());
			appointmentEntity.setDate(dto.getDate());
			appointmentEntity.setCreatedAt(LocalDateTime.now().toString());
			appointmentEntity.setCreatedBy(dto.getPatientId());
			appointmentEntity.setFullName(dto.getFullName());
			appointmentEntity.setTimeSlot(dto.getTimeSlot());
			appointmentEntity.setMobileNumber(dto.getMobileNumber());
			appointmentEntity.setGender(dto.getGender());
			appointmentEntity.setPatientId(dto.getPatientId());

			Response documentFile1;
			try {
				if (dto.getOpdFile() != null) {
					documentFile1 = Utility.uploadFile(dto.getOpdFile(), appointmentEntity.getAppointmentId() + "-OPD",
							"OPD_PHOTO\\");

					if (documentFile1.getStatusCode() == 200) {

						FileUploadPathDto fileUploadPathDto = (FileUploadPathDto) documentFile1.getResponse();

						appointmentEntity.setOpdFilePath(fileUploadPathDto.getFilePath());

					} else {

						return documentFile1;

					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			AppointmentEntity save = appointmentRepository.save(appointmentEntity);
			return Response.response("Appointment Successfully Booked", HttpStatus.OK, save);
		}
		return Response.response("Invalid Data", HttpStatus.BAD_REQUEST, null);
	}

}
