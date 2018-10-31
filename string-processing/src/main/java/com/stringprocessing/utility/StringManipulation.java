package com.stringprocessing.utility;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.stringprocessing.exception.WrongFormatException;

@Component("stringManip")
public class StringManipulation {

	private boolean isContainingNumber(String s) {

		/*
		 * Helper method to check if a string contains numerical characters
		 * 
		 */

		if (s == null || s.isEmpty()) {
			throw new WrongFormatException("Please avoid entering empty Strings");
		}

		Pattern p = Pattern.compile("[0-9]");
		// [0-9]
		Matcher m = p.matcher(s);

		return m.find();
	}

	public String removeDoubleLettersSet(String str) {

		if (str.length() > 30) {
			throw new WrongFormatException("Your string must be maximum 30 characters long");
		}

		if (isContainingNumber(str)) {
			throw new WrongFormatException("Please only enter a String without any numerical characters");
		}

		String[] result = str.split("");

		int length = result.length;

		Set<String> mySet = new TreeSet<>();

		for (int i = 0; i < length; i++) {

			mySet.add(result[i]);
		}

		return String.join("", mySet);

	}

}
