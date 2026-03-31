package com.swasthya.setu.response;

import org.springframework.http.HttpStatus;

public class Response {

	private int statusCode;
	private String message;

	private Object response;

	public Response(int statusCode, String message, Object response) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.response = response;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public Response() {
		super();
	}

	@Override
	public String toString() {
		return "Response [statusCode=" + statusCode + ", message=" + message + ", response=" + response + "]";
	}

	public static Response response(String message, HttpStatus status, Object object) {

		Response response = new Response();

		response.setMessage(message);

		response.setStatusCode(status.value());

		response.setResponse(object);

		return response;

	}

}
