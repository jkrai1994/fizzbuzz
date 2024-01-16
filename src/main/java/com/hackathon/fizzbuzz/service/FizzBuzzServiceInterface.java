package com.hackathon.fizzbuzz.service;

import java.util.List;

import com.hackathon.fizzbuzz.model.FizzBuzzRequestBody;

public interface FizzBuzzServiceInterface {

	
	 public List<String> fizzBuzzAlgo(FizzBuzzRequestBody fizzBuzzRequest);
}
