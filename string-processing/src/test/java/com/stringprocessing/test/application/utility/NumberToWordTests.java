package com.stringprocessing.test.application.utility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stringprocessing.utility.NumberToWords;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NumberToWordTests {

	@Autowired
	NumberToWords numberToWords;

	@Test
	public void testForZero() {

		try {
			assertEquals("Please enter only positive numerical characters", numberToWords.convert("0"));
		} catch (Exception e) {
			String expectedMessage = "Please enter only positive numerical characters";
			assertEquals("Exception message must be correct", expectedMessage, e.getMessage());
		}
	}

	@Test
	public void testForLargeNumber() {

		assertEquals("Nine Hundred Thousand, Ninety Nine Thousand Nine Hundred Ninety Nine ",
				numberToWords.convert("999999"));
	}

	@Test
	public void testForNegativeNumber() {

		try {
			assertEquals("Please enter only positive numerical characters", numberToWords.convert("-5"));
		} catch (Exception e) {
			String expectedMessage = "Please enter only positive numerical characters";
			assertEquals("Exception message must be correct", expectedMessage, e.getMessage());
		}
	}

}
