package com.stringprocessing.utility;

import org.springframework.stereotype.Component;

@Component("numberToWords")
public class NumberToWords {
	private static final String EMPTY = "";

	private static final String[] units = { EMPTY, "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ",
			"Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ",
			"Seventeen ", "Eighteen ", "Nineteen " };

	private static final String[] tens = { EMPTY, EMPTY, "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ",
			"Eighty ", "Ninety " };

	// Function to convert single digit or two digit number into words
	private static String convertToDigit(int n, String suffix) {
		// if n is zero
		if (n == 0) {
			return EMPTY;
		}

		// split n if it is more than 19
		if (n > 19) {
			return tens[n / 10] + units[n % 10] + suffix;
		} else {
			return units[n] + suffix;
		}
	}

	// Function to convert a given number (max 6-digits) into words
	public String convert(int n) {
		// for storing the word representation of given number
		StringBuilder res = new StringBuilder();

		// add digits at hundred thousands
		res.append(convertToDigit(((n / 100000) % 100), "Hundred Thousand, "));

		// add digits at thousands & tens thousands place
		res.append(convertToDigit(((n / 1000) % 100), "Thousand "));

		// add digit at hundreds place
		res.append(convertToDigit(((n / 100) % 10), "Hundred "));

		// add digits at ones & tens place
		res.append(convertToDigit((n % 100), ""));

		return res.toString();
	}

}
