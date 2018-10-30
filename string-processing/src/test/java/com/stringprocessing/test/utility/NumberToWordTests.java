package com.stringprocessing.test.utility;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.stringprocessing.utility.NumberToWords;

public class NumberToWordTests {

	Date timestamp;

	String nw;

	@Test
	public void testForZero() {
		assertEquals("", nw = new NumberToWords().convert(0));
	}

	@Test
	public void testForLargeNumber() {
		assertEquals("Nine Hundred Thousand, Ninety Nine Thousand Nine Hundred Ninety Nine ",
				nw = new NumberToWords().convert(999999));
	}

}
