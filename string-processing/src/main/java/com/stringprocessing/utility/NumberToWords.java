package com.stringprocessing.utility;

import org.springframework.stereotype.Component;

@Component("numberToWords")
public class NumberToWords {

	private static final String[] units = { "", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ",
			"Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ",
			"Eighteen ", "Nineteen " };

	private static final String[] tens = { "", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ",
			"Eighty ", "Ninety " };

	// Function to convert single digit or two digit number into words
	private static String convertToWords(int n, String s) {

		if (n == 0) {
			return "";
		}

		// split n if it is more than 19
		if (n > 19) {
			return tens[n / 10] + units[n % 10] + s;
		} else {
			return units[n] + s;
		}
	}

	// Function to convert a given number (max 6-digits) into words
	public String convert(int n) {
		// for storing the word representation of given number
		StringBuilder res = new StringBuilder();

		res.append(convertToWords(((n / 100000) % 100), "Hundred Thousand, "));

		res.append(convertToWords(((n / 1000) % 100), "Thousand "));

		res.append(convertToWords(((n / 100) % 10), "Hundred "));

		res.append(convertToWords((n % 100), ""));

		return res.toString();
	}

}
