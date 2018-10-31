package com.stringprocessing.test.application.utility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stringprocessing.utility.StringManipulation;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StringManipulationTests {

	@Autowired
	StringManipulation stringManip;

	@Test
	public void testForStringCeciEstUneChaineIsOk() {

		assertEquals("acehinstu", stringManip.removeDoubleLettersSet("ceciestunechaine"));
	}

	@Test
	public void testStringIsNotEmpty() {
		try {
			assertEquals("Please avoid entering empty Strings", stringManip.removeDoubleLettersSet(""));
		} catch (Exception e) {
			String expectedMessage = "Please avoid entering empty Strings";
			assertEquals("Exception message must be correct", expectedMessage, e.getMessage());
		}
	}

	@Test
	public void testStringIsNotNumerical() {
		try {
			assertEquals("Please only enter a String without any numerical characters",
					stringManip.removeDoubleLettersSet("45454"));
		} catch (Exception e) {
			String expectedMessage = "Please only enter a String without any numerical characters";
			assertEquals("Exception message must be correct", expectedMessage, e.getMessage());
		}
	}

	@Test
	public void testStringIsMaximumThirtyCharactersLong() {
		try {
			assertEquals("Your string must be maximum 30 characters long", stringManip.removeDoubleLettersSet(
					"zkieikfikpqieurqfjdlmskfjldskfjldskfjldskfjlskdjlfkjdslmfkjldskfjdlsfkjfjfflj"));
		} catch (Exception e) {
			String expectedMessage = "Your string must be maximum 30 characters long";
			assertEquals("Exception message must be correct", expectedMessage, e.getMessage());
		}
	}

}
