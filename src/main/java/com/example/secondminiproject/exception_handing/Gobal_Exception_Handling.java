package com.example.secondminiproject.exception_handing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Gobal_Exception_Handling {
	
	@ExceptionHandler(value=User_Define_Exception.class)
	public ResponseEntity<AppError> usernotfoundexception(User_Define_Exception exception)                                       
	{
		AppError error=new AppError();
		error.setErrormessage(exception.getMessage());
		error.setErrorcode(ResponseEntity.status
				(HttpStatus.INTERNAL_SERVER_ERROR));
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		
	}
	
	 @ExceptionHandler(ArithmeticException.class)
	    public ResponseEntity<String> handleArithmeticException(ArithmeticException ex) {
	        String errorMessage = "Arithmetic exception occurred: " + ex.getMessage();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	    }
	
	

}
