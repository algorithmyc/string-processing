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
	public void testForNineHundredThousandNinetyNineThousandNineHundredNinetyNineIsOk() {

		assertEquals("Nine Hundred Thousand, Ninety Nine Thousand Nine Hundred Ninety Nine ",
				numberToWords.convertNumberToWord("999999"));
	}

	@Test
	public void testForZero() {

		try {
			assertEquals("Please enter only positive numerical characters", numberToWords.convertNumberToWord("0"));
		} catch (Exception e) {
			String expectedMessage = "Please enter only positive numerical characters";
			assertEquals("Exception message must be correct", expectedMessage, e.getMessage());
		}
	}

	@Test
	public void testForNegativeNumber() {

		try {
			assertEquals("Please enter only positive numerical characters", numberToWords.convertNumberToWord("-5"));
		} catch (Exception e) {
			String expectedMessage = "Please enter only positive numerical characters";
			assertEquals("Exception message must be correct", expectedMessage, e.getMessage());
		}
	}

}
