package com.stringprocessing.utility;

import org.springframework.stereotype.Component;

import com.stringprocessing.exception.WrongFormatException;

@Component("numberToWords")
public class NumberToWords {

	private static final String[] units = { "", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ",
			"Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ",
			"Eighteen ", "Nineteen " };

	private static final String[] tens = { "", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ",
			"Eighty ", "Ninety " };

	public boolean isOnlyNumeric(String s) {
		// Checks also for any negative signs
		return (s.matches("[0-9]+") && s.length() > 2);

	}

	// Function to convert single digit or two digit number into words
	private String matchDigitsToUnits(int n, String s) {

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
	public String convertNumberToWord(String n) {

		if (!(isOnlyNumeric(n))) {
			throw new WrongFormatException("Please enter only positive numerical characters");
		}

		int parsedInt = 0;
		try {
			parsedInt = Integer.parseInt(n);
		} catch (NumberFormatException e) {

			throw new WrongFormatException("Please enter an integer not greater than " + Integer.MAX_VALUE);
		}

		if (parsedInt > 999999) {

			throw new WrongFormatException(
					"Numbers Greater than 999 999 not allowed, please enter a positive natural number between 0 and 999 999");
		}

		StringBuilder res = new StringBuilder();

		res.append(matchDigitsToUnits(((parsedInt / 100000) % 100), "Hundred Thousand, "));

		res.append(matchDigitsToUnits(((parsedInt / 1000) % 100), "Thousand "));

		res.append(matchDigitsToUnits(((parsedInt / 100) % 10), "Hundred "));

		res.append(matchDigitsToUnits((parsedInt % 100), ""));

		return res.toString();
	}

}
