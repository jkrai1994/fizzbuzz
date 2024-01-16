package com.hackathon.fizzbuzz.service;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hackathon.fizzbuzz.model.FizzBuzzRequestBody;

@Service
public class RequestDataCounterImpl  implements RequestDataCounterInterface{

	private final Map<FizzBuzzRequestBody, Long> requestDataCountMap = new ConcurrentHashMap<>();
	@Override
	public void countRequestData(FizzBuzzRequestBody fizzBuzzRequest) {
		requestDataCountMap.put(fizzBuzzRequest, requestDataCountMap.getOrDefault(fizzBuzzRequest, 0L) + 1);
	}
	@Override
	public ConcurrentMap<FizzBuzzRequestBody, Long> getAllRequestDataCounts() {
		Long maxValueInMap = (Collections.max(new ConcurrentHashMap<>(requestDataCountMap).values()));
		System.out.println(maxValueInMap);
		return new ConcurrentHashMap<>(requestDataCountMap).entrySet().stream().filter(x -> x.getValue() == maxValueInMap).collect(Collectors.toConcurrentMap(x -> x.getKey(), x -> x.getValue()));

	}
}
