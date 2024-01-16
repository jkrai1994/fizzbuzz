package com.hackathon.fizzbuzz.model;

import java.util.Objects;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class FizzBuzzRequestBody {

	@jakarta.validation.constraints.NotBlank
	private String str2;
	@Min(1)
	private int int1;
	@Min(1)
	private int int2;
	@Min(1)
	private int limit;

	@jakarta.validation.constraints.NotBlank
	private String str1;

	public FizzBuzzRequestBody(int int1, int int2, int limit, String str1, String str2) {
		super();
		this.str1 = str1;
		this.str2 = str2;
		this.int1 = int1;
		this.int2 = int2;
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "FizzBuzzRequestBody [str1=" + str1 + ", str2=" + str2 + ", int1=" + int1 + ", int2=" + int2 + ", limit="
				+ limit + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(int1, int2, limit, str1, str2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FizzBuzzRequestBody other = (FizzBuzzRequestBody) obj;
		return int1 == other.int1 && int2 == other.int2 && limit == other.limit && Objects.equals(str1, other.str1)
				&& Objects.equals(str2, other.str2);
	}

}
