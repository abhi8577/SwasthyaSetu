package com.swasthya.setu.utility;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.swasthya.setu.dto.FileUploadPathDto;
import com.swasthya.setu.response.Response;

@Component

public class Utility {

	public static Response uploadFile(MultipartFile file, String fileName, String folderName) throws Exception {

		System.out.println("inside uploadFile method");

		try {

			// System.out.println(file.getContentType());

			if (file.isEmpty()) {

				return Response.response("Upload file was empty", HttpStatus.BAD_REQUEST, null);

			}

			// Get the file and save it somewhere

			byte[] bytes = file.getBytes();

			double rand = Math.random();

			String random = String.valueOf(rand);

			random = random.substring(random.indexOf(".") + 1);

			// For Local

			// Path path = Paths.get("C:\\fileUploadTest\\"+fileName+"_"+random);

			// For PROD

			Path path = Paths.get("D:\\setu_upload_file\\" + folderName + fileName + ".jpeg");

			Path filePath = Files.write(path, bytes);

			FileUploadPathDto filePathDto = new FileUploadPathDto();

			filePathDto.setFilePath(filePath.toString());

			return Response.response("File upload successfully", HttpStatus.OK, filePathDto);

		} catch (Exception e) {

			throw e;

		}

	}

	private static final Random random = new Random();

	public static String generateUniqueNumber() {

		long timestamp = System.currentTimeMillis(); // Get current timestamp in milliseconds

		int randomInt = random.nextInt(10000); // Generate a random integer (between 0 and 9999)

		return "PD-" + timestamp + String.format("%04d", randomInt); // Format the random integer

	}

	public static String generateAppointmentNumber() {

		long timestamp = System.currentTimeMillis(); // Get current timestamp in milliseconds

		int randomInt = random.nextInt(10000); // Generate a random integer (between 0 and 9999)

		return "APN-" + timestamp + String.format("%04d", randomInt); // Format the random integer

	}

}
