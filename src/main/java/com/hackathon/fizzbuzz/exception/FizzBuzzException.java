package com.hackathon.fizzbuzz.exception;

import org.springframework.http.HttpStatus;

public class FizzBuzzException {	
	private final String message;
private final Throwable throwable;
private final HttpStatus httpstatus ;

public FizzBuzzException(String message, Throwable throwable, HttpStatus httpstatus) {
	super();
	this.message = message;
	this.throwable = throwable;
	this.httpstatus = httpstatus;
}

public String getMessage() {
	return message;
}

public Throwable getThrowable() {
	return throwable;
}

public HttpStatus getHttpstatus() {
	return httpstatus;
}




	

}
