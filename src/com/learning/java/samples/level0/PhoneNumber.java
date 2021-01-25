package com.freshworks.java.samples.level0;

import java.util.ArrayList;
import java.util.List;

public final class PhoneNumber {
	private final short areaCode;
	private final short prefix; 
	private final short lineNum;

	public PhoneNumber(int areaCode, int prefix, int lineNum) {
		this.areaCode = rangeCheck(areaCode, 999, "area code");
		this.prefix   = rangeCheck(prefix,   999, "prefix");
		this.lineNum  = rangeCheck(lineNum, 9999, "line num");
	}

	private static short rangeCheck(int val, int max, String arg) {
		if (val < 0 || val > max)
			throw new IllegalArgumentException(arg + ": " + val);
		return (short) val;
	}

	@Override 
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof PhoneNumber))
			return false;
		PhoneNumber pn = (PhoneNumber)o;
		return pn.lineNum == lineNum && pn.prefix == prefix
				&& pn.areaCode == areaCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + areaCode;
		result = prime * result + lineNum;
		result = prime * result + prefix;
		return result;
	}
	
	@Override
	public String toString() {
		return "PhoneNumber [areaCode=" + areaCode + ", prefix=" + prefix + ", lineNum=" + lineNum + "]";
	}

	public static void main(String[] args) {
		List<PhoneNumber> numbers = new ArrayList<>();
		numbers.add(new PhoneNumber(111, 111, 111));
		numbers.add(new PhoneNumber(112, 211, 112));
		numbers.add(new PhoneNumber(113, 311, 113));
		numbers.add(new PhoneNumber(114, 411, 114));
		
		// Factory method
		// Returns an immutable List instance
		List<PhoneNumber> immutableNumbers = List.of(
				new PhoneNumber(111, 111, 111),
				new PhoneNumber(112, 211, 112),
				new PhoneNumber(113, 311, 113),
				new PhoneNumber(114, 411, 114));
		
		// For each loop in Java
		for(PhoneNumber p: numbers) {
			System.out.println(p);
		}
		
		// Higher Order Functions
		// Passing a function reference
		immutableNumbers.forEach(System.out::println);
	}
}

