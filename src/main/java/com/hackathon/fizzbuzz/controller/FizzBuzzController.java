package com.hackathon.fizzbuzz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.fizzbuzz.model.FizzBuzzRequestBody;
import com.hackathon.fizzbuzz.service.FizzBuzzServiceImpl;
import com.hackathon.fizzbuzz.service.RequestDataCounterImpl;

@RestController
@RequestMapping
public class FizzBuzzController {

	@Autowired
	private RequestDataCounterImpl requestDataCounter;

	@Autowired
	private FizzBuzzServiceImpl fizzbuzz;

	@PostMapping("/fizzbuzz")
	public ResponseEntity decodeFizzBuzz(@RequestBody @Valid FizzBuzzRequestBody fizzBuzzRequest ) {

		requestDataCounter.countRequestData(fizzBuzzRequest);
		List<String> res = new ArrayList<>();
		res = fizzbuzz.fizzBuzzAlgo(fizzBuzzRequest);
		
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	@GetMapping("/request-data-counts")
	public Optional<ConcurrentMap<FizzBuzzRequestBody, Long>> getRequestDataCounts() {
		return Optional.ofNullable(requestDataCounter.getAllRequestDataCounts());
	}

}
