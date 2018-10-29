package com.stringprocessing.utility;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("stringManip")
public class StringManipulation {

	private Logger logger = LogManager.getLogger(StringManipulation.class);

	public String removeDoubleLettersSet(String str) {

		// Take string as input
		// Traverse the string
		// Count for double letters in my string
		// If they are double remove them

		String[] result = str.split("");

		int length = result.length;
		/*
		 * TreeSet has a log(n) time complexity guarantuee for add()/remove()/contains()
		 * methods. Sorting an ArrayList takes n*log(n) operations, but add()/get()
		 * takes only 1 operation.
		 */

		// So if you're mainly retrieving, and don't sort often, ArrayList is the better
		// choice. If you sort often but dont retrieve that much TreeSet would be a
		// better choice.

		Set<String> mySet = new TreeSet<String>();

		// In case I need to use a threadsafe solution
		Set<String> syncTreeSet = Collections.synchronizedSet(mySet);

		if (length <= 1) {
			logger.error("Your string is empty");
		}

		for (int i = 0; i < length; i++) {

			mySet.add(result[i]);
		}

		String joined = String.join("", mySet);

		return joined;

	}

}
