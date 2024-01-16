package com.hackathon.fizzbuzz.exception;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FizzBuzzExceptionController {
	
	
//	@ExceptionHandler(value = {FizzBuzzNotFound.class})
//	public ResponseEntity<Object> fizzBuzzNotFound(FizzBuzzNotFound fizzBuzzNotFound){
//		FizzBuzzException ex= new FizzBuzzException(fizzBuzzNotFound.getMessage(), fizzBuzzNotFound.getCause(),HttpStatus.NOT_FOUND);
//		//FizzBuzzException ex= new FizzBuzzException(fizzBuzzNotFound.getMessage(), fizzBuzzNotFound.getCause(), HttpStatus.NOT_FOUND);
//		return new  ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
//		
//	}
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        // Build a response with validation errors
        StringBuilder errorMessage = new StringBuilder("Validation errors:\n");
        for (FieldError fieldError : fieldErrors) {
            errorMessage.append(fieldError.getField())
                         .append(": ")
                         .append(fieldError.getDefaultMessage())
                         .append("\n");
        }
        return ResponseEntity.badRequest().body(errorMessage.toString());

    }
}



