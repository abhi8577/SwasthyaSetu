package com.swasthya.setu.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swasthya.setu.response.Response;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UtilityController {

	@GetMapping("/viewFile")
	public ResponseEntity<?> viewFile(@RequestParam String filePath) {

	    try {
	        Path path = Paths.get(filePath);
	        Resource resource = new UrlResource(path.toUri());

	        if (!resource.exists() || !resource.isReadable()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body(new Response(404, "File not found", null));
	        }

	        // 🔍 Detect content type
	        String contentType = Files.probeContentType(path);

	        // ⚡ Fallback if null
	        if (contentType == null) {
	            String fileName = path.getFileName().toString().toLowerCase();

	            if (fileName.endsWith(".pdf")) {
	                contentType = "application/pdf";
	            } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
	                contentType = "image/jpeg";
	            } else if (fileName.endsWith(".png")) {
	                contentType = "image/png";
	            } else if (fileName.endsWith(".gif")) {
	                contentType = "image/gif";
	            } else {
	                contentType = "application/octet-stream"; // default
	            }
	        }

	        // 🧠 Decide inline or download
	        boolean isViewable = contentType.startsWith("image/") 
	                             || contentType.equals("application/pdf");

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(contentType))
	                .header(HttpHeaders.CONTENT_DISPOSITION,
	                        (isViewable ? "inline" : "attachment") +
	                                "; filename=\"" + path.getFileName().toString() + "\"")
	                .body(resource);

	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(new Response(500, "Error while reading file", e.getMessage()));
	    }
	}
}