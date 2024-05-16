package com.example.secondminiproject.exception_handing;

import org.springframework.http.ResponseEntity.BodyBuilder;

public class AppError {
	
	public BodyBuilder errorcode;
	public String errormessage;
	
	
	public BodyBuilder getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(BodyBuilder bodyBuilder) {
		this.errorcode = bodyBuilder;
	}
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

}
