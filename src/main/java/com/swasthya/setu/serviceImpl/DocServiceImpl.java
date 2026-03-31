package com.swasthya.setu.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.swasthya.setu.dto.DocRemarkDto;
import com.swasthya.setu.dto.FileUploadPathDto;
import com.swasthya.setu.entity.AppointmentEntity;
import com.swasthya.setu.repository.AppointmentRepository;
import com.swasthya.setu.response.Response;
import com.swasthya.setu.service.DocService;
import com.swasthya.setu.utility.Utility;

@Service
public class DocServiceImpl implements DocService {

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
		byAppointmentId.setStatus("CONSULTED");
		byAppointmentId.setDrRemarkTime(LocalDateTime.now().toString());

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

		if (byDate != null || !byDate.isEmpty()) {
			return Response.response("Data Fetched Successfully", HttpStatus.OK, byDate);

		}
		return Response.response("Data Not Available For This Date", HttpStatus.NOT_FOUND, null);

	}

	@Override
	public Response findAppointmentByStatus(String status) {
		List<AppointmentEntity> byAppointmentStatus = appointmentRepository.findByStatus(status);
		if (byAppointmentStatus != null || !byAppointmentStatus.isEmpty()) {
			return Response.response("Data Fetched Successfully", HttpStatus.OK, byAppointmentStatus);
		}

		return Response.response("Data Not Available For This Status", HttpStatus.NOT_FOUND, null);
	}

}
