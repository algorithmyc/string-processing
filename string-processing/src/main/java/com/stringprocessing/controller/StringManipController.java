package com.stringprocessing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stringprocessing.exception.ResourceNotFoundException;
import com.stringprocessing.exception.WrongFormatException;
import com.stringprocessing.model.ProcessedString;
import com.stringprocessing.utility.NumberToWords;
import com.stringprocessing.utility.StringManipulation;

@Controller
public class StringManipController {

	@Autowired
	private StringManipulation stringManip;

	@Autowired
	private NumberToWords numberToWords;

	private String result;

	private String number;

	@GetMapping("/")
	@ResponseBody
	public String home(@RequestParam(name = "value", required = false, defaultValue = "") String value) {

		return "Welcome to the String Processing Application";
	}

	@GetMapping("/stringDedup")
	@ResponseBody
	public ProcessedString doManip(@RequestParam(name = "value", required = false, defaultValue = "") String value) {

		if (value == null || value.isEmpty()) {
			throw new WrongFormatException("Please only enter a String with at least two double letters and no numerical value");
		}

		if (stringManip.stringContainsNumber(value)) {
			throw new WrongFormatException("Please only enter a String without any numerical value");
		}

		result = stringManip.removeDoubleLettersSet(value);

		return new ProcessedString(result);

	}

	@GetMapping("/writeNumber")
	@ResponseBody
	public ProcessedString getWriteNumber(
			@RequestParam(name = "value", required = false, defaultValue = "") int value) {

		if (value < 0) {
			throw new WrongFormatException(
					"Negative numbers not allowed, please enter a positive natural number between 0 and 999 999");
		}

		if (value > 999999) {

			throw new WrongFormatException(
					"Numbers Greater than 999 999 not allowed, please enter a positive natural number between 0 and 999 999");
		}

		number = numberToWords.convert(value);

		return new ProcessedString(number);

	}

}
