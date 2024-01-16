package com.hackathon.fizzbuzz.service;

import java.util.concurrent.ConcurrentMap;

import com.hackathon.fizzbuzz.model.FizzBuzzRequestBody;

public interface RequestDataCounterInterface {
	
	
	void countRequestData(FizzBuzzRequestBody fizzBuzzRequest);
	 ConcurrentMap<FizzBuzzRequestBody, Long> getAllRequestDataCounts();

}
