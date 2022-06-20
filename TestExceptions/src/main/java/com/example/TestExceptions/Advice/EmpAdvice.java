package com.example.TestExceptions.Advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.TestExceptions.custmExce.EmptyException;

@ControllerAdvice
public class EmpAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmptyException.class)
	public String handleEmptyException(EmptyException empExc){
		
		return empExc.getErrorMessage();
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuch(NoSuchElementException noSuEle){
		
		return new ResponseEntity<String>("I did find such Id", HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, 
			HttpHeaders headers, 
			HttpStatus status, 
			WebRequest request){
		
		return new ResponseEntity<Object>("Change API Method", HttpStatus.NOT_FOUND);
		
	}
	

}
