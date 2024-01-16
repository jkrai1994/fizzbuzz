package com.hackathon.fizzbuzz.exception;

public class  FizzBuzzNotFound extends Exception{
	public FizzBuzzNotFound(String message){
		super(message);
		
	}
	
	public FizzBuzzNotFound(String message, Throwable throwable) {
		
		super (message, throwable);
		// TODO Auto-generated constructor stub
	}
	
	

}
