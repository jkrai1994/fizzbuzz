package com.hackathon.fizzbuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hackathon.fizzbuzz.model.FizzBuzzRequestBody;

@Service
public class FizzBuzzServiceImpl  implements FizzBuzzServiceInterface{
	
	
	@Override
    public List<String> fizzBuzzAlgo(FizzBuzzRequestBody fizzBuzzRequest) {
        List<String> result = new ArrayList<>();
        int limit= fizzBuzzRequest.getLimit(), int1= fizzBuzzRequest.getInt1(),int2=fizzBuzzRequest.getInt2();
        String str1= fizzBuzzRequest.getStr1(),str2= fizzBuzzRequest.getStr2();
        for (int i = 1; i <= limit; i++) {
            StringBuilder value = new StringBuilder();
            if (i % int1 == 0) {
                value.append(str1);
            }
            if (i % int2 == 0) {
                value.append(str2);
            }
            result.add(value.length() == 0 ? String.valueOf(i) : value.toString());
        }
        return result;
    }

}
