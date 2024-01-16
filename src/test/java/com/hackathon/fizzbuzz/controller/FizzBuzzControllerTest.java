package com.hackathon.fizzbuzz.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hackathon.fizzbuzz.model.FizzBuzzRequestBody;
import com.hackathon.fizzbuzz.service.FizzBuzzServiceImpl;
import com.hackathon.fizzbuzz.service.RequestDataCounter;
import com.hackathon.fizzbuzz.service.RequestDataCounterImpl;

@WebMvcTest(FizzBuzzController.class)
@ExtendWith(MockitoExtension.class)
public class FizzBuzzControllerTest {

	@MockBean
	FizzBuzzServiceImpl fizzBuzzService;

	@InjectMocks
	FizzBuzzController fizzBuzz;

	@MockBean
	private RequestDataCounterImpl requestDataCounter;

	@Autowired
	MockMvc mockMvc;

	public static FizzBuzzRequestBody fizzbuzzRequestBody;
	public static FizzBuzzRequestBody fizzbuzzRequestBody400;

	public static List<String> decoded;

	@BeforeAll
	public static void setUp() {
		fizzbuzzRequestBody = new FizzBuzzRequestBody(3, 5, 15, "fizz", "buzz");
		fizzbuzzRequestBody400 = new FizzBuzzRequestBody(1, 5, 15, "", "buzz");
		decoded = new ArrayList<>();
		decoded.add("two");

	}

	@Test
	public void decodeFizzBuzzTest() throws JsonProcessingException, Exception {

		List<String> expectedList = new ArrayList<>();
		expectedList.add("1");
		expectedList.add("2");
		expectedList.add("fizz");
		expectedList.add("4");
		expectedList.add("buzz");
		expectedList.add("fizz");
		expectedList.add("7");
		expectedList.add("8");
		expectedList.add("fizz");
		expectedList.add("buzz");
		expectedList.add("11");
		expectedList.add("fizz");
		expectedList.add("13");
		expectedList.add("14");
		expectedList.add("fizzbuzz");

		requestDataCounter.countRequestData(fizzbuzzRequestBody);

		verify(requestDataCounter).countRequestData(Mockito.any(FizzBuzzRequestBody.class));
		
		when(fizzBuzzService.fizzBuzzAlgo(fizzbuzzRequestBody)).thenReturn(expectedList);
		
		ResponseEntity<List<String>> result = fizzBuzz.decodeFizzBuzz(fizzbuzzRequestBody);
		assertEquals(expectedList, result.getBody());
		assertEquals(HttpStatus.OK, result.getStatusCode());

	}
	
	
	
//	@Test
//	public void decodeFizzBuzzTest_400() throws JsonProcessingException, Exception {
//
//		List<String> expectedList = new ArrayList<>();
//		expectedList.add("1");
//		expectedList.add("2");
//		expectedList.add("fizz");
//		expectedList.add("4");
//		expectedList.add("buzz");
//		expectedList.add("fizz");
//		expectedList.add("7");
//		expectedList.add("8");
//		expectedList.add("fizz");
//		expectedList.add("buzz");
//		expectedList.add("11");
//		expectedList.add("fizz");
//		expectedList.add("13");
//		expectedList.add("14");
//		expectedList.add("fizzbuzz");
//
//		requestDataCounter.countRequestData(fizzbuzzRequestBody);
//
//		verify(requestDataCounter).countRequestData(Mockito.any(FizzBuzzRequestBody.class));
//		
//		when(fizzBuzzService.fizzBuzzAlgo(fizzbuzzRequestBody400)).thenThrow(BadRequest.class);
//		
//		ResponseEntity<List<String>> result = fizzBuzz.decodeFizzBuzz(fizzbuzzRequestBody400);
//		assertEquals(expectedList, result.getBody());
//		assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
//
//	}

}
