package com.hackathon.fizzbuzz.service;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hackathon.fizzbuzz.model.FizzBuzzRequestBody;

@Component
public class RequestDataCounter {

	private final Map<FizzBuzzRequestBody, Long> requestDataCountMap = new ConcurrentHashMap<>();

	public void countRequestData(FizzBuzzRequestBody fizzBuzzRequest) {
		System.out.println("=====================================================");
		requestDataCountMap.put(fizzBuzzRequest, requestDataCountMap.getOrDefault(fizzBuzzRequest, 0L) + 1);
	}

	public ConcurrentMap<FizzBuzzRequestBody, Long> getAllRequestDataCounts() {
		Long maxValueInMap = (Collections.max(new ConcurrentHashMap<>(requestDataCountMap).values()));
		System.out.println(maxValueInMap);
		return new ConcurrentHashMap<>(requestDataCountMap).entrySet().stream().filter(x -> x.getValue() == maxValueInMap).collect(Collectors.toConcurrentMap(x -> x.getKey(), x -> x.getValue()));
		
		//return new ConcurrentHashMap<>(requestDataCountMap).entrySet().stream().max((s1,s2) -> s1.getValue().compareTo(s2.getValue()));
		//return new ConcurrentHashMap<>(requestDataCountMap);
	}
}
